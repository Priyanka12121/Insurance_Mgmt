<table>

    <tr>
        <td>
            <table>
                <th>Details of claim:</th>
                <tr>
                    <td>FNOL ID : <strong>${Fnol.fnolId}</strong></td>
                </tr>
                <tr>
                    <td>policy Number : <strong>${Fnol.policyNumber}</strong></td>
                </tr>
                <tr>
                    <td>DL Number : <strong>${Fnol.driverLicense}</strong></td>
                </tr>
                <tr>
                    <td>Vehicle number : <strong>${Fnol.vehicleNumber}</strong></td>
                </tr>
                <tr>
                    <td>Police Report: <strong>${Fnol.policeReport}</strong> </td>
                </tr>
                <tr>
                    <td>claim status:<strong> ${Fnol.status} </strong></td>
                </tr>
                <tr>
                    <td>comments/message Report:<strong> ${Fnol.reasonOfRejection} </strong></td>
                </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td>

            <button type="button" class="btn btn-primary text-light mt-3 w-100" onclick="fetchIMVapi()">check insurance validity</button>

        </td>
        <td>

            <button type="button" class="btn btn-primary text-light mt-3 w-100" onclick="fetchdmvapi()">check DMV validity</button>

        </td>
    </tr>
    <tr>
        <td>

            <button type="button" class="btn btn-warning text-light mt-2 w-100" onclick="functionApprove(${Fnol.fnolId})">Approve</button>

        </td>
        <td>

            <button type="button" class="btn btn-warning  text-light mt-2 w-100" onclick="functionReject(${Fnol.fnolId})">Reject</button>

        </td>
    </tr>
</table>