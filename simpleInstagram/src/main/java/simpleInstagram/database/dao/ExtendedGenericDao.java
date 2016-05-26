package simpleInstagram.database.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import org.hibernate.Session;

import simpleInstagram.database.modelenity.BaseEntity;


public class ExtendedGenericDao<T, ID extends Serializable> extends GenericDao<T, ID> {

	public ExtendedGenericDao(Session session) {
		super(session);
		// TODO Auto-generated constructor stub
	}

	private void updateBaseData(T entity) {
		if (((BaseEntity) entity).getCreateDate() == null ) {
			((BaseEntity) entity).setCreateDate(new Date());
		}
		((BaseEntity) entity).setUpdateDate(new Date());
	}

	// @Override
	public T makePersistent(T entity) {
		if (entity instanceof BaseEntity) {
			updateBaseData(entity);
		}

		return super.makePersistent(entity);
	}

	public void persist(T entity) {
		if (entity instanceof BaseEntity) {
			updateBaseData(entity);
		}
		super.persist(entity);
	}

	public void batchPersist(Collection<T> batch) {
		for (T entity : batch) {
			if (entity instanceof BaseEntity) {
				updateBaseData(entity);
			}
		}

		super.batchPersist(batch);
	}

	public void batchSaveOrUpdate(Collection<T> batch) {
		for (T entity : batch) {
			if (entity instanceof BaseEntity) {
				updateBaseData(entity);
			}
		}

		super.batchSaveOrUpdate(batch);
	}
}
