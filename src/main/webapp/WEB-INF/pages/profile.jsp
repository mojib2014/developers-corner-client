
<div class="container panel panel-default mt-5"
	ng-controller="ProfileController">
	<h1 class="mb-4" id="title">{{user.lastName}}'s Profile</h1>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>CreatedAt</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td id="fName">{{user.firstName}}</td>
				<td>{{user.lastName}}</td>
				<td>{{user.email}}</td>
				<td>{{user.createdAt[1]}} {{user.createdAt[2]}}
					{{user.createdAt[0]}}</td>
				<td>
					<button type="button" id="openModalBtn" ng-click="openModal(user)"
						class="btn btn-success custom-width">Edit</button>
					<button type="button" ng-click="deleteUserProfile(user.id)"
						class="btn btn-danger custom-width">Remove</button>
				</td>
			</tr>
		</tbody>
	</table>
	<div ng-show="showModal" class="modal-container" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Edit Profile Form</h5>
				<button ng-click="closeModal()" id="closeModal" type="button" class="close"
					data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form name="profileForm" ng-submit="editUserProfile(user)">
					<input type="hidden" ng-model="user.id" />
					<div class="input-group mb-3">
						<span class="input-group-text">First Name </span> <input
							type="text" name="firstName" id="firstName" ng-model="user.firstName"
							class="form-control" placeholder="John" aria-label="First Name"
							aria-describedby="First Name" required ng-minlength="5" />
					</div>
					<div class="alert alert-danger"
						ng-show="profileForm.firstName.$touched && profileForm.firstName.$error.required">
						This is a required field</div>
					<div class="alert alert-danger"
						ng-show="profileForm.firstName.$error.minlength">Minimum
						length required is 5</div>


					<div class="input-group mb-3">
						<span class="input-group-text" >Last Name </span> <input
							type="text" name="lastName" id="lastName" ng-model="user.lastName"
							class="form-control" placeholder="Doe" aria-label="Last Name"
							aria-describedby="Last Name" required ng-minlength="5" />
					</div>
					<!-- Last Name errors -->
					<div class="alert alert-danger"
						ng-show="profileForm.lastName.$touched && profileForm.lastName.$error.required">
						This is a required field</div>
					<div class="alert alert-danger"
						ng-show="profileForm.lastName.$error.minlength">Minimum
						length required is 5</div>


					<div class="input-group mb-3">
						<span class="input-group-text">Nick Name </span> <input
							type="text" name="nickName" id="nickName" ng-model="user.nickName"
							class="form-control" placeholder="John (Optional)"
							aria-label="Nick Name" aria-describedby="Nick Name" />
					</div>

					<div class="input-group mb-3">
						<span class="input-group-text">Email </span> <input
							type="email" name="email" id="formEmail" ng-model="user.email"
							class="form-control" placeholder="john.doe@domain.com"
							aria-label="Eamil" aria-describedby="Email" required />
					</div>
					<!-- Email errors  -->
					<div class="alert alert-danger"
						ng-show="profileForm.email.$touched && profileForm.email.$error.required">
						This is a required field</div>
					<div class="alert alert-danger" ng-show="profileForm.$error.email">This
						field is invalid</div>

					<div class="input-group mb-3">
						<span class="input-group-text" id="basic-addon1"> <svg
								xmlns="http://www.w3.org/2000/svg" width="16" height="16"
								fill="currentColor" class="bi bi-lock" viewBox="0 0 16 16">
	  						<path
									d="M8 1a2 2 0 0 1 2 2v4H6V3a2 2 0 0 1 2-2zm3 6V3a3 3 0 0 0-6 0v4a2 2 0 0 0-2 2v5a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V9a2 2 0 0 0-2-2zM5 8h6a1 1 0 0 1 1 1v5a1 1 0 0 1-1 1H5a1 1 0 0 1-1-1V9a1 1 0 0 1 1-1z" />
							</svg>
						</span> <input type="password" ng-model="user.password" name="password"
							id="password" class="form-control" placeholder="m@2#ac%" aria-label="Password"
							aria-describedby="basic-addon1" required ng-minlength="6" />
					</div>
					<!-- Password errors  -->
					<div class="alert alert-danger"
						ng-show="profileForm.password.$touched && profileForm.password.$error.required">This
						is a required field</div>
					<div class="alert alert-danger"
						ng-show="profileForm.password.$error.minlength">Minimum
						length required is 6</div>
					<div class="alert alert-danger"
						ng-show="profileForm.$error.password">This field is invalid</div>

					<div class="form-actions floatRight">
						<input class="btn btn-primary"  ng-disabled="profileForm.$invalid" id="submitBtn" type="submit" value="Edit" />
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal"
					ng-click="closeModal()">Close</button>
			</div>
		</div>
	</div>
</div>
