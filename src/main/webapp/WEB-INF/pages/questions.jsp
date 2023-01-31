<div ng-controller="QuestionController">
	<div class="container panel panel-default mt-5">
		<h1 class="mb-4" id="title">Your Questions</h1>
		<table class="table table-hover" id="questionTable">
			<thead>
				<tr>
					<th>Username</th>
					<th>Tags</th>
					<th>Role</th>
					<th>Question</th>
					<th>UserId</th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="question in questions" id="list">
					<td id="username">{{question.username}}</td>
					<td>{{question.tags}}</td>
					<td>{{question.role}}</td>
					<td>{{question.question}}</td>
					<td>{{question.user.id}}</td>
					<td>
						<button type="button" id="openModal" ng-click="openModal(question)"
							class="btn btn-success custom-width">Edit</button>
						<button type="button" id="removeBtn" ng-click="deleteUserQuestion(question.id)"
							class="btn btn-danger custom-width">Remove</button>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div ng-show="showModal" class="modal-container" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Edit Question Form</h5>
				<button ng-click="closeModal()" type="button" class="close"
					data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form name="questionForm" ng-submit="updateUserQuestion()">
					<input type="hidden" ng-model="question.id" />
					<div class="input-group mb-3">
						<span class="input-group-text" id="basic-addon1">User Name</span>
						<input type="text" name="username" id="formUsername" ng-model="question.username"
							class="form-control" placeholder="mojib2014"
							aria-label="Username" aria-describedby="basic-addon1" required />
					</div>
					<!-- username errors -->
				<div class="alert alert-danger" id="username-required"
					ng-show="questionForm.username.$touched && questionForm.username.$error.required">
					This is a required field</div>
				<div class="alert alert-danger"
					ng-show="questionForm.username.$error.minlength">Minimum
					length required is 5</div>
					
					<div class="mb-3">
						<input type="radio" id="student" name="role"
							ng-model="question.role" value="student"
							class="button btn-sm btn-info student-btn" required /> <label
							class="mr-3" for="student">I'm a Student</label> <input
							type="radio" id="mentor" name="role" ng-model="question.role"
							value="mentor" class="button btn-sm btn-info mentor-btn" required />
						<label for="mentor">I'm a Mentor</label>
					</div>
					<!-- role errors -->
				<div class="alert alert-danger"
					ng-show="questionForm.role.$touched && questionForm.role.$error.required">
					This is a required field</div>
					
					<div class="input-group mb-3">
						<span class="input-group-text" id="basic-addon1">Tags</span> <input
							type="text" name="tags" id="tags" ng-model="question.tags"
							class="form-control" placeholder="Java" aria-label="Tags"
							aria-describedby="basic-addon1" required />
					</div>
					<!-- tags errors -->
				<div class="alert alert-danger"
					ng-show="questionForm.tags.$touched && questionForm.tags.$error.required">
					This is a required field</div>
					
					<div class="input-group mb-3">
						<textarea name="question" id="question" ng-model="question.question"
							class="form-control" rows="3"
							placeholder="Enter a topic you wanna search for" required></textarea>
					</div>
					<!-- question errors -->
				<div class="alert alert-danger"
					ng-show="questionForm.question.$touched && questionForm.question.$error.required">
					This is a required field</div>
				<div class="alert alert-danger"
					ng-show="questionForm.question.$error.minlength">Minimum
					length required is 5</div>
					
					<div class="form-actions floatRight">
						<input class="btn btn-primary" ng-disabled="questionForm.$invalid" type="submit" id="submitBtn" value="Save" />
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