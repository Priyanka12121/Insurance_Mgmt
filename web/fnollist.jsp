<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--        <link href="css/header.css" rel="stylesheet">-->
        <link rel="stylesheet" href="css/all.min.css">
        <link rel="stylesheet" href="css/reset-min.css">
        <link rel="stylesheet" href="css/algolia-min.css">
        <link rel="stylesheet" href="css/header.css">
        <link rel="stylesheet" href="css/docs.min.css">
        <link rel="stylesheet" href="css/index.css">
        <link href="css/customstyle.css" rel="stylesheet">
        <title>Verify FNOL Page</title>
        <style>
            #table {
                display: block;
                height: 250px;
                width: 100%;
                overflow-y: scroll;
                outline: 1px solid black;
                outline-color: gray
            }
            #table > thead > tr > th{
                background-color: #BDCDD6;
            }
            #tableId{

                width: 100%;

            }
            div.scroll {

                width: 100%;
                height: 300px;
                overflow-x: hidden;
                overflow-y: auto;
                text-align: justify-all;
                padding: 20px;
            }

        </style>
        <script>

            function fetchContent(fnolId)
            {
                //alert(fnolId);
                var xmlhttp = new XMLHttpRequest();
                xmlhttp.onreadystatechange = function ()
                {
                    document.getElementById("onclickViewDiv").innerHTML = xmlhttp.responseText;
                };


                xmlhttp.open("POST", "FetchParticularFnol?fnolId=" + fnolId, true);
                xmlhttp.send();
            }
            function fetchdmvapi()
            {
                //alert(1);
                var xmlhttp = new XMLHttpRequest();
                xmlhttp.onreadystatechange = function ()
                {
                    document.getElementById("dmvdetails").innerHTML = xmlhttp.responseText;
                };


                xmlhttp.open("POST", "FetchDMVApi", true);
                xmlhttp.send();
                //FetchIMasterApi
            }
            function fetchIMVapi()
            {
                //alert(hello from imv);
                var xmlhttp = new XMLHttpRequest();
                xmlhttp.onreadystatechange = function ()

                {
                    document.getElementById("insurancedetails").innerHTML = xmlhttp.responseText;
                };


                xmlhttp.open("POST", "FetchIMasterApi", true);
                xmlhttp.send();
                //FetchIMasterApi

            }
            function functionApprove(fnolId)
            {
                //alert(fnolId);
                var xmlhttp = new XMLHttpRequest();
                xmlhttp.onreadystatechange = function ()
                {
                    document.getElementById("onclickViewDiv").innerHTML = xmlhttp.responseText;
                };


                xmlhttp.open("POST", "UnderwriterVerified?fnolId=" + fnolId, true);
                xmlhttp.send();
            }
            function functionReject(fnolId)
            {
                //alert(fnolId);
                var xmlhttp = new XMLHttpRequest();
                xmlhttp.onreadystatechange = function ()
                {
                    document.getElementById("onclickViewDiv").innerHTML = xmlhttp.responseText;
                };


                xmlhttp.open("POST", "UnderwriterReject?fnolId=" + fnolId, true);
                xmlhttp.send();
            }


        </script>
    </head>



    <!-- I want to check my session before showing any content to the user -->




    <jsp:include page="menu.jsp"></jsp:include>

        <div id="example">

        <c:if test="${UpdateMsg != null}">
            <div class="alert alert-success" role="alert">
                ${UpdateMsg}
            </div>
        </c:if>


        <div class="fixed-table-toolbar"><div class="bs-bars float-left">

            </div><div class="columns columns-right btn-group float-right"><div class="keep-open btn-group" title="Columns">
                    <div class="dropdown-menu dropdown-menu-right" style=""><label class="dropdown-item dropdown-item-marker"><input type="checkbox" data-field="id" value="0" checked="checked"> <span>ID</span></label><label class="dropdown-item dropdown-item-marker"><input type="checkbox" data-field="name" value="1" checked="checked"> <span>Item Name</span></label><label class="dropdown-item dropdown-item-marker"><input type="checkbox" data-field="price" value="2" checked="checked"> <span>Item Price</span></label></div></div></div></div>



        <div class="fixed-table-body">
            <div id="initialfnollist">
                <table id="table" data-height="400" data-virtual-scroll="true" class="table table-bordered table-hover" style="margin-top: -9.5px;">
                    <thead>
                        <c:choose>
                            <c:when test = "${requestScope.noData != null}">
                                <tr>
                                    <td colspan="5">
                                        <h2 style="border:2px solid rgb(255, 99, 71); background-color:rgba(255, 99, 71, 0.5); font-size:15px;">
                                            <c:out value="${requestScope.noData}"> </c:out>
                                            </h2>
                                        </td>
                                    </tr>
                            </c:when>
                        </c:choose>
                        <tr>
                            <th>FNOL ID</th>
                            <th>Email</th>
                            <th>Policy No</th>
                            <th>RP firstname</th>
                            <th>RP LastName</th>
                            <th>DOI</th>
                            <th>A_STATE</th>
                            <th>VO Firstname</th>
                            <th>VO Lastname</th>
                            <th>Vehicle No</th>
                            <th>Police Report</th>
                            <th>DL no.</th>
                            <th>Desc. Acc</th>
                            <th>Status</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>

                        <c:forEach items="${FnolList}" var="fnol">

                            <tr data-index="0">
                                <td>${fnol.fnolId}</td>
                                <td>${fnol.emailAddress}</td>
                                <td>${fnol.policyNumber}</td>
                                <td>${fnol.reportingPartyFirstName}</td>
                                <td>${fnol.reportingPartyLastName}</td>
                                <td>${fnol.dateOfIncident}</td>
                                <td>${fnol.accidentState}</td>
                                <td>${fnol.vehicleOwnerFirstName}</td>
                                <td>${fnol.vehicleOwnerLastName}</td>
                                <td>${fnol.vehicleNumber}</td>
                                <td>${fnol.policeReport}</td>
                                <td>${fnol.driverLicense}</td>
                                <td>${fnol.descriptionOfAccident}</td>
                                <td>
                                    <c:if test="${fnol.status.equalsIgnoreCase('Approved')}">
                                        <p  style="color:blue">${fnol.status} </p></c:if>
                                    <c:if test="${fnol.status.equalsIgnoreCase('Rejected')}">
                                        <p  style="color:blue">${fnol.status} </p></c:if>
                                    <c:if test="${fnol.status.equalsIgnoreCase('Awaiting for Final Approval')}">
                                        <p  style="color:darkcyan">${fnol.status} </p></c:if>
                                    <c:if test="${fnol.status.equalsIgnoreCase('Pending')}">
                                        <p  style="color: blueviolet">${fnol.status} </p></c:if>
                                    </td>
                                    <td>

                                        <button type="button" class="btn btn-dark" onclick="fetchContent(${fnol.fnolId})">View</button>



                                </td>
                            </tr>
                        </c:forEach>

                    </tbody>
                </table>
            </div>
            <div class="scroll">
                <table id="tableId" class="table-borderless">
                    <tr>
                        <td rowspan = "2">
                            <div id="onclickViewDiv">

                            </div>
                        </td>
                        <td>
                            <div id="insurancedetails">


                            </div>

                        </td>
                    <tr>
                        <td>
                            <div id="dmvdetails">

                            </div>
                        </td>
                    </tr>

                    </tr>
                </table>
            </div>

        </div>

</html>

