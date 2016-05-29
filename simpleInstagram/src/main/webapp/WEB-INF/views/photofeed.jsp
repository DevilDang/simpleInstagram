<div class="container-fluid">
	<div class="panel panel-primary" ng-controller="photoFeedController">
		<div class="panel-heading">Photo feed : [${photoFeedID}]</div>
		<div class="panel-body">

			<!-- upload file -->
			<div class="row">
				<!-- image -->
				<div class="col-sm-8">
					<img alt="" src="[[imgUrl]]">
				</div>
				<!-- info -->
				<div class="col-sm-4">
					<!-- user name -->
					<div class="row">
						<div class="row">
							<div class="col-sm-12">User: [[username]]</div>
						</div>
					</div>

					<!-- description -->
					<div class="row">
						<div class="col-sm-12">Description: [[description]]</div>
					</div>

					<!-- Add comment -->
					<div class="row">
						<div class="col-sm-8">
							<textarea rows="3" cols="40" ng-model="commentContent"></textarea>
						</div>
						<div class="col-sm-4">
							<button class="btn btn-lg btn-primary btn-block" value=add
								ng-click="addComment()">Add</button>
						</div>
					</div>

					<!-- comments -->
					<div class="row" ng-repeat="comment in comments">
						<div class="col-sm-4">[[comment.username]] :</div>
						<div class="col-sm-8">[[comment.content]]</div>
					</div>
				</div>


			</div>

		</div>
	</div>
</div>
