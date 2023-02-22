
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
    <head>
        <title>Insurance Management</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <meta name="theme-color" content="#712cf9">

        <!-- Custom styles for this template -->
        <link href="css/header.css" rel="stylesheet">
        <link href="css/customstyle.css" rel="stylesheet">

        <!--<link href="css/carousel.css" rel="stylesheet">-->

    </head>
    <header class="p-3 text-bg-dark">
        <div class="container">
            <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
                <div style="padding: 10px">
                    <a href="landingPage.jsp">
                        <img src="images/car_insurance_logo2.jpg" width="350" height="100"></img></a></div>


                <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                    <c:if test="${User==null}">
<!--                        <li id="menulinks"><a href="#carInsurancePlans" class="nav-link px-2 text-white">Car Insurance Plans</a></li>
                        <li id="menulinks"><a href="#buyInsurancePolicy" class="nav-link px-2 text-white">Buy Car Insurance</a></li>
                        <li id="menulinks"><a href="#aboutUs" class="nav-link px-2 text-white">About us</a></li>-->

                    </c:if>

                    <c:if test="${User.roleId == '1'}">
                        <li id="menulinks"><a href="firstnoticeofloss.jsp" class="nav-link px-2 text-white">Log FNOL</a></li>

                        <li id="menulinks"><a href="ViewLoggedFNOLForCustomer?emailAddress=${User.emailAddress}" class="nav-link px-2 text-white">claim status</a></li>
<!--                        <li id="menulinks"><a href = "mailto:abc@example.com?subject = Feedback&body = Message"class="nav-link px-2 text-white">
                                Send Feedback
                            </a>
                        <li id="menulinks"><a href="landingPage.jsp?#aboutUs" class="nav-link px-2 text-white">About us</a></li>-->
                        <!--<a href="#" class="nav-link px-2 text-white">contact us</a></li>-->
                    </c:if>

                    <c:if test="${User.roleId == '2'}">
                        <li id="menulinks"><a href="ViewLoggedFNOL" class="nav-link px-2 text-white">Pending Applications</a></li>
<!--                        <li id="menulinks"><a href="landingPage.jsp?#aboutUs" class="nav-link px-2 text-white">About us</a></li>-->

                    </c:if>
                    <c:if test="${User.roleId == '3'}">
                        <li id="menulinks"><a href="PendingFNOLverification" class="nav-link px-2 text-white">Pending verification</a></li>
<!--                        <li id="menulinks"><a href="landingPage.jsp?#aboutUs" class="nav-link px-2 text-white">About us</a></li>-->
                        <!--                        <li><a href="#" class="nav-link px-2 text-white">Claim verification</a></li>
                                                <li><a href="#" class="nav-link px-2 text-white">policy verification(Insurance Master)</a></li>
                                                <li><a href="#" class="nav-link px-2 text-white">DMV verification</a></li>-->
                    </c:if>



                    <c:if test="${User!=null}">
                        <li id="menulinks"><a class="nav-link px-2 text-white text-capitalize text-opacity-75">
                                welcome: ${User.firstName}  ${User.lastName}
                            </a></li>
                        </c:if>
                </ul>


                <c:if test="${User==null}">
                    <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" role="search">
                        <input type="search" class="form-control form-control-dark text-bg-dark" placeholder="Search..." aria-label="Search">
                    </form>
                </c:if>

                <div class="text-end">
                    <% if (request.getSession().getAttribute("User") == null) {%>

                    <a href="login.jsp">
                        <button type="button" class="btn btn-outline-light me-2" >Login</button>
                    </a>
                    <a href="SignUp">
                        <button type="button" class="btn btn-outline-light me-2">Sign-up</button>
                    </a>
                    <%
                    } else {%>

                    <a href="Logout">
                        <button type="button" class="btn btn-outline-light me-2" >Log Out</button>
                    </a>
                    <%
                        }
                    %>


                </div>
            </div>
        </div>
    </header>
