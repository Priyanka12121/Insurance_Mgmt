<!doctype html>
<html lang="en">
    <head>
        <title>FNOL FORM</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/signin.css" rel="stylesheet">
        <style>
            .bordered {
                width: 600px;
                border: 6px solid black;
            }
        </style>

    </head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="s" uri="/struts-tags"%>
    <body class="text-center flex-column p-0">
        <div class="w-100">
            <jsp:include page="menu.jsp"></jsp:include>
            </div>

            <main class="form-signin w-100 m-auto">
                <div class="bordered">
                    <form action="LogFNOL" method="post">
<!--                        <img class="mb-4" src="https://www.mulesoft.com/sites/default/files/2020-12/Exavalu%20Logo.png" alt="" height="57">-->
                        <h3 class="h3 mb-3 fw-normal">FIRST NOTICE OF LOSS</h3>
                        <table>
                            <tr>
                                <td>Your Email:</td>
                                <td>
                                    <input class="form-control" name="emailAddress" type="email" class="form-control" id="floatingInput" placeholder="name@example.com" value="${User.emailAddress}" required readonly><hr>
                            </td>
                        </tr>
                        <tr>
                            <td>Policy Number:</td>
                            <td>
                                <input class="form-control" name="policyNumber" type="text" class="form-control" id="policyNumber" placeholder="policy number"  required><hr>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                DATE & TIME OF INCIDENT:
                            </td>
                            <td>
                                <input class="form-control" name="dateOfIncident" type="text" id="date" placeholder="dd/mm/yyyy" required>
                            </td>
                            <td>
                                <select class="form-control" name="timeOfIncident">
                                    <option value="01:00">01:00</option>
                                    <option value="02:00">02:00</option>
                                    <option value="03:00">03:00</option>
                                    <option value="04:00">04:00</option>
                                    <option value="05:00">05:00</option>
                                    <option value="06:00">06:00</option>
                                    <option value="07:00">07:00</option>
                                    <option value="08:00">08:00</option>
                                    <option value="09:00">09:00</option>
                                    <option value="10:00">10:00</option>
                                    <option value="11:00">11:00</option>
                                    <option value="12:00">12:00</option>
                                    <option value="13:00">13:00</option>
                                    <option value="14:00">14:00</option>
                                    <option value="15:00">15:00</option>
                                    <option value="16:00">16:00</option>
                                    <option value="17:00">17:00</option>
                                    <option value="18:00">18:00</option>
                                    <option value="19:00">19:00</option>
                                    <option value="20:00">20:00</option>
                                    <option value="21:00">21:00</option>
                                    <option value="22:00">22:00</option>
                                    <option value="23:00">23:00</option>
                                    <option value="00:00">00:00</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <hr>REPORTING PARTY NAME:</td>
                            <td>
                                <input class="form-control"name="reportingPartyFirstName" type="text"  id="firstName" placeholder="first name" required>
                            </td>
                            <td>
                                <input class="form-control"name="reportingPartyLastName" type="text"  id="lastName" placeholder="last name" required>
                            </td>
                        </tr>
                        <tr>
                            <td><hr>Address of Accident:</td>
                            <td>
                                <input class="form-control" name="accidentStreetAddress" type="text"  id="streetAddress" placeholder="street Address" required>

                            </td>
                            <td>
                                <input class="form-control" name="accidentCity" type="text"  id="city" placeholder="city" required>

                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>
                                <input class="form-control" name="accidentState" type="text"  id="state" placeholder="state/province" required>


                            </td>
                            <td>
                                <input class="form-control" name="accidentZipcode" type="text"  id="zipcode" placeholder="zip code/postal" required>

                            </td>
                        </tr>
                        <tr>
                            <td><hr>Vehicle Owner Name:</td>
                            <td>
                                <input class="form-control" name="vehicleOwnerFirstName" type="text"  id="vehicleownerfirstName" placeholder="First Name" required>

                            </td>
                            <td>
                                <input class="form-control" name="vehicleOwnerLastName" type="text"  id="vehicleownerlastName" placeholder="Last Name" required>

                            </td>
                        </tr>
                        <tr>
                            <td><hr>Vehicle Owner Address:</td>
                            <td>
                                <input class="form-control" name="vehicleOwnerStreetAddress" type="text"  id="vehicleownerstreetAddress" placeholder="street Address" required>

                            </td>
                            <td>
                                <input class="form-control" name="vehicleOwnerCity" type="text"  id="vehicleownercity" placeholder="city" required>

                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>
                                <input name="vehicleOwnerState" type="text"  id="vehicleownerstate" placeholder="state/province" required>
                            </td>
                            <td>
                                <input name="vehicleOwnerZipcode" type="text"  id="vehicleownerzipcode" placeholder="zip code/postal" required>

                            </td>
                        </tr>
                        <hr>
                        <tr>
                            <td><hr>Vehicle Owner Phone:</td>
                            <td>
                                <input class="form-control" name="vehicleOwnerPhone" type="text"  id="vehicleownerphone" placeholder="phone number" required>

                            </td>

                        </tr>
                        <tr>
                            <td>
                                <hr>Police Report?
                            </td>
                            <td>
                                <input type="radio" id="policereportyes" name="policeReport" value="yes">
                                <label for="policereportyes">yes</label>
                                <input type="radio" id="policereportno" name="policeReport" value="no">
                                <label for="policereportno">no</label>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <hr> Vehicle Information:
                            </td>
                            <td>
                                <input class="form-control" name="vehicleNumber" type="text"  id="vehiclenumber" placeholder="vehicle number" required>

                            </td>
                        </tr>
                        <tr>
                            <td>
                                <hr>Driving License:
                            </td>
                            <td>
                                <input class="form-control" name="driverLicense" type="text"  id="driverlicense" placeholder="DL number" required>

                            </td>
                        </tr>
                        <tr>
                            <td>
                                <hr>Accident Description:
                            </td>
                            <td>
                                <textarea class="form-control" name="descriptionOfAccident" id="textarea" rows="10" placeholder="Description of accident"></textarea>

                            </td>
                        </tr>

                    </table>
                    <button class="w-100 btn btn-lg btn-primary mt-4" type="submit">Submit FONL</button>
                    <p class="mt-5 mb-3 text-muted"></p>
                </form>
            </div>
        </main>
    </body>
</html>