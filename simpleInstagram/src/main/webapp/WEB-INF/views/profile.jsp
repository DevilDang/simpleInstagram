<div class="container-fluid" ng-controller="profileController">
	<div class="panel panel-primary">
		<div class="panel-heading">Profile</div>
		<div class="panel-body">
			<!-- User name -->
			<div class="row">
				<div class="col-sm-12">
					<label>[[username]]</label>
				</div>
			</div>
			<!-- Email -->
			<div class="row">
				<div class="col-sm-12">
					<label>[[email]]</label>
				</div>
			</div>
			<!-- Meta data -->
			<div class="row">
				<div class="col-sm-4">
					<label>[[countPostFeed]] post</label>
				</div>
				<div class="col-sm-4">
					<label>[[countFollower]] followers</label>
				</div>
				<div class="col-sm-4">
					<label>[[countFollowing]] following</label>
				</div>
			</div>
		</div>
	</div>

	<div class="panel panel-primary">
		<div class="panel-heading">Post Feed</div>
		<div class="panel-body">

			<div class="row" style="border: 1px; border-color: black;"
				ng-repeat="postFeeds in rows">
				<div class="col-sm-4" ng-repeat="postFeed in postFeeds">
					<a href="photofeed?feedId=[[postFeed.feedId]]"> 
 					<img alt="" src="[[postFeed.imgUrl]]" width="400"
						height="400">
					</a>
				</div>
			</div>

		</div>
	</div>

</div>