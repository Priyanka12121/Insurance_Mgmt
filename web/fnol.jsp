<!doctype html>
<html lang="en">
    <head>
        <title>FNOL FORM</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/signin.css" rel="stylesheet">

    </head>
    <%@taglib prefix="s" uri="/struts-tags"%>
    <body class="text-center flex-column p-0">
        <div class="w-100">
            <jsp:include page="menu.jsp"></jsp:include>
            </div>

            <main class="form-signin w-100 m-auto">
                <form action="LogFNOL" method="post">
                    <img class="mb-4" src="https://www.mulesoft.com/sites/default/files/2020-12/Exavalu%20Logo.png" alt="" height="57">
                    <h1 class="h3 mb-3 fw-normal">Please sign in</h1>

                    <div class="form-floating">
                        <input name="email" type="email" class="form-control" id="floatingInput" placeholder="name@example.com" value="${User.emailAddress}" required>
                    <label for="floatingInput">Email address</label>
                </div>
                <div class="form-floating mb-3">
                    <input name="policyNumber" type="text" class="form-control" id="policyNumber" placeholder="Policy Number" required>
                    <label for="policyNumber">Policy Number</label>
                </div>


                <div class="form-group">
                    <div class="form-floating mb-3">

                        <textarea class="form-control" name="description" id="exampleFormControlTextarea1" rows="10" placeholder="Description of accident"></textarea>

                    </div>
                </div>
                <div class="form-floating mb-3">
                    <input name="vehicleNumber" type="text" class="form-control" id="vehicleNumber" placeholder="Vehicle Number" required>
                    <label for="vehicleNumber">Vehicle Number</label>
                </div>
                <button class="w-100 btn btn-lg btn-primary" type="submit">Log FNL</button>
                <p class="mt-5 mb-3 text-muted">&copy; 2017?2022</p>
            </form>
        </main>
    </body>
</html>