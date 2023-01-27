    <main class="container" ng-controller="AuthController">
      <form ng-submit="login()" name="loginForm">
        <div class="panel container-xsm m-auto">
          <div class="panel-title" id="title"><h1>Login Form</h1></div>
          <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon1">@</span>
            <input
              type="email"
              id="email"
              ng-model="user.email"
              name="email"
              class="form-control"
              placeholder="email@example.com"
              aria-label="Email"
              aria-describedby="basic-addon1"
              required
            />
          </div>
          <!-- Email errors  -->
          <div
            class="alert alert-danger"
            ng-show="
              loginForm.email.$touched && loginForm.email.$error.required
            "
          >
            This is a required field
          </div>
          <div class="alert alert-danger" ng-show="loginForm.$error.email">
            This field is invalid
          </div>

          <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon1">
              <svg
                xmlns="http://www.w3.org/2000/svg"
                width="16"
                height="16"
                fill="currentColor"
                class="bi bi-lock"
                viewBox="0 0 16 16"
              >
                <path
                  d="M8 1a2 2 0 0 1 2 2v4H6V3a2 2 0 0 1 2-2zm3 6V3a3 3 0 0 0-6 0v4a2 2 0 0 0-2 2v5a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V9a2 2 0 0 0-2-2zM5 8h6a1 1 0 0 1 1 1v5a1 1 0 0 1-1 1H5a1 1 0 0 1-1-1V9a1 1 0 0 1 1-1z"
                />
              </svg>
            </span>
            <input
              type="password"
              id="password"
              ng-model="user.password"
              name="password"
              class="form-control"
              placeholder="m@2#ac%"
              aria-label="Password"
              aria-describedby="basic-addon1"
              required
              ng-minlength="6"
            />
          </div>
          <!-- Password errors  -->
          <div
            class="alert alert-danger"
            ng-show="
              loginForm.password.$touched && loginForm.password.$error.required
            "
          >
            This is a required field
          </div>
          <div
            class="alert alert-danger"
            ng-show="loginForm.password.$error.minlength"
          >
            Minimum length required is 6
          </div>
          <div class="alert alert-danger" ng-show="loginForm.$error.password">
            This field is invalid
          </div>

          <!-- Form submit button -->
          <div class="form-actions floatRight">
            <input
              class="btn btn-primary"
              type="submit"
              value="Login"
              id="loginBtn"
              ng-disabled="loginForm.$invalid"
            />
          </div>
        </div>
      </form>
    </main>
    
  