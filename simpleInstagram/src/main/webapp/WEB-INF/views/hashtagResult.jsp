<div class="container-fluid">
	<div class="panel panel-primary" ng-controller="resultHashTagController">
		<div class="panel-heading">Result for ${searchHashTag}</div>
		<div class="panel-body">
			<div class="row" ng-repeat="photoFeed in photoFeeds">
				<!-- User name -->
				<div class="row">
					<div class="col-sm-2">[[photoFeed.username]]</div>
				</div>
				<!-- Image -->
				<div class="row">
					<div class="col-sm-2">
						<a href="photofeed?feedId=[[photoFeed.feedId]]"><img alt=""
							src="[[photoFeed.imgUrl]]"></a>

					</div>
				</div>
				<!-- description -->
				<div class="row">
					<div class="col-sm-2">
						<p ng-bind-html="photoFeed.description"></p>
					</div>
				</div>

			</div>
		</div>
	</div>

</div>