package simpleInstagram.database.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.LockOptions;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public abstract class GenericDao<T, ID extends Serializable> {

	private Class<T> persistentClass;
	private Session session;

	
	@SuppressWarnings("unchecked")
	public GenericDao(Session session) {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
		this.session = session;
	}
	
	protected Session getSession() {
		return session;
		// return HibernateUtil.getSessionFactory().getCurrentSession();
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	public T getById(ID id, boolean lock) {
		T entity;
		if (lock) {
			entity = (T) getSession().get(getPersistentClass(), id, LockOptions.UPGRADE);
		} else {
			entity = (T) getSession().get(getPersistentClass(), id);
		}
		return entity;
	}

	public T findById(ID id, boolean lock) {
		T entity;
		if (lock) {
			entity = (T) getSession().load(getPersistentClass(), id, LockOptions.UPGRADE);
		} else {
			entity = (T) getSession().load(getPersistentClass(), id);
		}
		return entity;
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll(String sortField, String sortOrder) {
		Criteria crit = getSession().createCriteria(getPersistentClass());

		if (sortOrder.equalsIgnoreCase("ASCENDING")) {
			crit.addOrder(Order.asc(sortField));
		} else {
			crit.addOrder(Order.desc(sortField));
		}

		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll(String sortField, String sortOrder, int limit) {
		Criteria crit = getSession().createCriteria(getPersistentClass());

		crit.setMaxResults(limit);

		if (sortOrder.equalsIgnoreCase("ASCENDING")) {
			crit.addOrder(Order.asc(sortField));
		} else {
			crit.addOrder(Order.desc(sortField));
		}

		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll(String sortField, String sortOrder, HashMap<String, Object> filters) {
		Criteria crit = getSession().createCriteria(getPersistentClass());

		if (sortOrder.equalsIgnoreCase("ASCENDING")) {
			crit.addOrder(Order.asc(sortField));
		} else {
			crit.addOrder(Order.desc(sortField));
		}

		if (filters.size() > 0) {
			Set<String> keys = filters.keySet();
			for (String key : keys) {
				crit = crit.add(Restrictions.eq(key, filters.get(key)));
			}

		}

		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll(String sortField, String sortOrder, HashMap<String, Object> filters, int limit) {
		Criteria crit = getSession().createCriteria(getPersistentClass());

		if (limit != 0) {
			crit.setMaxResults(limit);
		}

		if (sortOrder.equalsIgnoreCase("ASCENDING")) {
			crit.addOrder(Order.asc(sortField));
		} else {
			crit.addOrder(Order.desc(sortField));
		}

		if (filters.size() > 0) {
			Set<String> keys = filters.keySet();
			for (String key : keys) {
				crit = crit.add(Restrictions.eq(key, filters.get(key)));
			}

		}

		return crit.list();
	}

	public List<T> findAll() {
		return findByCriteria();
	}

	
	public T makePersistent(T entity) {
		getSession().saveOrUpdate(entity);
		return entity;
	}

	public void persist(T entity) {
		getSession().persist(entity);
	}

	public void makeTransient(T entity) {
		getSession().delete(entity);
	}

	public T merge(T entity) {
		getSession().merge(entity);
		return entity;
	}

	public void flush() {
		getSession().flush();
	}

	public void clear() {
		getSession().clear();
	}

	public void batchPersist(Collection<T> batch) {
		for (T entity : batch) {
			getSession().persist(entity);
		}
	}

	public void batchSaveOrUpdate(Collection<T> batch) {
		for (T entity : batch) {
			makePersistent(entity);
		}
	}


	public void batchDelete(Collection<T> batch) {
		for (T entity : batch) {
			makeTransient(entity);
		}
	}

	/**
	 * Use this inside subclasses as a convenience method.
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findByCriteria(Criterion... criterion) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		for (Criterion c : criterion) {
			crit.add(c);
		}

		return crit.list();
	}

}
