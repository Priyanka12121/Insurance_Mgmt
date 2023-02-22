<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
        <title>Verify FNOL Page</title>

    </head>

    <!<!-- I want to check my session before showing any content to the user -->



    <body>
        <jsp:include page="menu.jsp"></jsp:include>

            <div id="example">
                <script>
                    init({
                        title: 'Large data',
                        desc: 'Use `virtualScroll` to enable the virtual scroll to play with large data sets (10000 rows).',
                        links: ['bootstrap-table.min.css'],
                        scripts: ['bootstrap-table.min.js']
                    });
                </script>

                <div class="bootstrap-table bootstrap5">

                    <div class="table-responsive" >

                        <div class="fixed-table-body">
                            <table id="table" data-virtual-scroll="true" class="table table-bordered table-hover table-striped" >
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

                                    <th>Reason/Message</th>
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
                                                <p  style="color:blue">${fnol.status} </p></c:if>
                                            </td>
                                        <c:if test="${fnol.reasonOfRejection!=null}">
                                            <td>
                                                <p style="color:brown"> ${fnol.reasonOfRejection}</p>
                                            </td>
                                        </c:if>
                                        <c:if test="${fnol.reasonOfRejection==null}">
                                            <td>
                                                <p style="color:goldenrod">processing..</p>
                                            </td>
                                        </c:if>


                                    </tr>
                                </c:forEach>

                            </tbody>
                        </table>




                        <script>
                            var $table = $('#table')
                            var total = 0

                            function getData(number, isAppend) {
                                if (!isAppend) {
                                    total = 0
                                }
                                var data = []
                                for (var i = total; i < total + number; i++) {
                                    data.push({
                                        'id': i,
                                        'name': 'Item ' + i,
                                        'price': '$' + i
                                    })
                                }
                                if (isAppend) {
                                    total += number
                                } else {
                                    total = number
                                }
                                $('#total').text(total)
                                return data
                            }

                            function mounted() {
                                $table.bootstrapTable({data: getData(20)})

                                $('#load').click(function () {
                                    $table.bootstrapTable('load', getData(10000))
                                })

                                $('#append').click(function () {
                                    $table.bootstrapTable('append', getData(10000, true))
                                })
                            }
                        </script>
                    </div>
                    </body>
                    </html>

