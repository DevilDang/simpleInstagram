
<div class="container-fluid" ng-controller="mainpageController">

	<div class="panel panel-primary">
		<div class="panel-heading">Create New Photo Feed</div>
		<div class="panel-body">

			<!-- upload file -->
			<div class="row">
				<div class="col-sm-2">File Upload :</div>
				<div class="col-sm-2">
					<input type="file" id="file" name="file">
				</div>
				<div class="col-sm-2">
					<progress></progress>
				</div>

			</div>
			<!-- upload file -->
			<div class="row">
				<div class="col-sm-2">
					<img id="uploadedImg" alt="" src="">
				</div>


			</div>

			<!-- description -->
			<div class="row">
				<form id="photoFeed">
					<div class="col-sm-10">
						<div class="form-group">
							<label for="comment">Description:</label>
							<textarea ng-model="photoFeed.description" required
								class="form-control" rows="5" id="description"></textarea>
						</div>

					</div>
					<input type="hidden" name="uploadedFilename"
						ng-model="photoFeed.uploadedFilename"> <input
						type="hidden" name="uploadedUrlName"
						ng-model="photoFeed.uploadedUrlName">

				</form>

			</div>
			<div class="row">
				<div class="col-sm-2">
					<button class="btn btn-lg btn-primary btn-block" name="login"
						ng-click="createPhotoFeed()">Save</button>
				</div>

			</div>

		</div>
	</div>
	<div class="panel panel-primary">
		<div class="panel-heading">New Photo Feeds</div>
		<div class="panel-body">

			<div class="row" ng-repeat="photoFeed in photoFeeds">
				<!-- User name -->
				<div class="row">
					<div class="col-sm-2">[[photoFeed.username]]</div>
				</div>
				<!-- Image -->
				<div class="row">
					<div class="col-sm-2">
						<img alt="" src="[[photoFeed.imgUrl]]">
					</div>
				</div>
				<!-- description -->
				<div class="row">
					<div class="col-sm-2">
						<span>[[photoFeed.description]]</span>
					</div>
				</div>

			</div>

		</div>
	</div>
</div>
