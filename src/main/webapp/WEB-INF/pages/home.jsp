<div class="container" ng-controller="ChatController">
	<section>
		<h1>Welcome to Developers Corner</h1>
		<p>This is the banner area</p>
	</section>
	<article class="row alignt-items-center"  ng-controller="QuestionController">
		<aside
			class="col col-2 your-status aside-left shadow-lg p-3 bg-body rounded">
			<h3>Your Status</h3>
		</aside>
		<section class="col col-8 ask-question-form possible-solutions">
			<h2>Check In</h2>
			<!-- Question form -->
			<form ng-submit="fetchAnswersFromMdnAndStackoverflow()"
				name="questionForm" ng-show="!displayAnswers">
				<div class="input-group mb-3">
					<span class="input-group-text" id="basic-addon1">User Name</span> <input
						type="text" name="username" ng-model="question.username"
						class="form-control" placeholder="mojib2014" aria-label="Username"
						aria-describedby="basic-addon1" required />
				</div>
				<div class="mb-3">
					<input type="radio" id="student" name="role"
						ng-model="question.role" value="student"
						class="button btn-sm btn-info student-btn" required /> <label
						class="mr-3" for="student">I'm a Student</label> <input
						type="radio" id="mentor" name="role" value="mentor"
						class="button btn-sm btn-info mentor-btn" required /> <label
						for="mentor">I'm a Mentor</label>
				</div>
				<div class="input-group mb-3">
					<span class="input-group-text" id="basic-addon1">Tags</span> <input
						type="text" name="tags" ng-model="question.tags"
						class="form-control" placeholder="Java" aria-label="Tags"
						aria-describedby="basic-addon1" required />
				</div>
				<div class="input-group mb-3">
					<textarea name="topic" ng-model="question.question"
						class="form-control" rows="3"
						placeholder="Enter a topic you wanna search for" required></textarea>
				</div>
				<div class="form-actions floatRight">
					<input class="btn btn-primary" type="submit" value="Go" />
				</div>
			</form>
			<div ng-show="displayAnswers">
				<div>
					<button ng-click="newQuestion()"
						class="new-question btn btn-warning float-right mb-3">New
						Question</button>
					<h2 class="sub-title mb-3">Possible Solutions</h2>
					<div ng-repeat="answer in answers"
						class="bg-body border border-gray shadow-lg roudned p-3">
						<h3>{{answer.title}}</h3>
						<a target="_blank" href={{answer.link}}>{{answer.title}}</a>
						<p>Rating: {{answer.score}}</p>
					</div>
				</div>
			</div>
		</section>
		<aside 
			ng-controller="UserController"
			class="col col-2 users-online aside-right shadow-lg p-3 bg-body rounded">
			<h3>Users Online</h3>
			<div ng-repeat="user in users">
				<p>{{user.lastName}} {{user.type}} <button ng-click="openChatModal(user)" class="btn btn-sm btn-primary chat-btn">Chat</button></p>
			</div>
		</aside>
	</article>
	<div ng-show="modalOpen" class="modal-container" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Chat</h5>
				<button ng-click="closeChatModal()" type="button" class="close"
					data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div>
					<p ng-repeat="message in messages"><span>{{message.sender}}: </span>{{message.message}}</p>
				</div>
				<form name="chatForm" ng-submit="sendMessage()">
					<input type="hidden" ng-model="message.id" />
					<div class="input-group mb-3">
						<span class="input-group-text" id="basic-addon1">Message</span>
						<textarea name="message" ng-model="message.message"
							class="form-control" rows="3" placeholder="Start chating"
							required></textarea>
					</div>
					<div class="form-actions floatRight">
						<input class="btn btn-primary" type="submit" value="Send" />
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal"
					ng-click="closeChatModal()">Close</button>
			</div>
		</div>
	</div>
</div>
