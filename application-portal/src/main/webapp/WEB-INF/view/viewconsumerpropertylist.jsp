<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
  <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <!DOCTYPE html>
        <html lang="en">

        <head>
          <title>View All Consumer Property</title>
          <meta charset="utf-8">
          <meta name="viewport" content="width=device-width, initial-scale=1.0">
          <link href="https://fonts.googleapis.com/css2?family=Playfair+Display:ital@1&display=swap" rel="stylesheet">
          <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        </head>
        <style>
          body {
            /* background-image: url("https://th.bing.com/th/id/OIP.ZkYyqtqDJwFCl7cZsij08gHaEA?w=305&h=180&c=7&r=0&o=5&dpr=1.5&pid=1.7");
      ; */
            background-size: 100%;

          }
        </style>
        <nav class="navbar navbar-expand-lg"
          style="background-color:  rgb(107, 4, 128);color: #fff;justify-content: space-between;">
          <div class="container-fluid">

            <div class="collapse navbar-collapse" id="navbarScroll">
              <ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll" style="--bs-scroll-height: 100px;">
                <li class="nav-item">
                  <img src="/images/Easy.png" alt="image" height="42px" width="42px" style="margin-left: 11px;">
                </li>
                <li class="nav-item">
                  <a class="nav-link active" aria-current="page" href="#" style="color: rgb(236, 238, 226) ;font-size: 24px; font-family:Times New Roman, Times, serif ;font-weight: bolder; margin-top: -6px;">Easy
                    Policy</a>
                </li>


              </ul>
              <ul class="d-flex navbar-nav  my-2 my-lg-0 navbar-nav-scroll" style="--bs-scroll-height: 100px;  font-family:Times New Roman, Times, serif; font-size: 18px;">
                <li class="nav-item"><a href="/home" class="nav-link active " aria-current="page" style="color: rgb(236, 243, 194); padding-right: 30px;">Home</a></li>

                <li class="nav-item"><a href="/home/about" class="nav-link active" aria-current="page"
                    style="color: rgb(236, 243, 194);padding-right: 30px;">About</a></li>

                <li class="nav-item"><a href="/home/contact" class="nav-link active" aria-current="page"
                    style="color: rgb(236, 243, 194);padding-right: 30px;">Contact</a></li>

                <li class="nav-item"><a href="/home/logout" class="nav-link active" aria-current="page"
                    style="color: rgb(236, 243, 194);padding-right: 20px;">Logout</a></li>
              </ul>
            </div>
          </div>
        </nav>
        </head>

        <body>
          <div class="container d-flex justify-content-between border rounded shadow mt-5 "
            style="padding: 0px !important;height: auto;width:auto">

            <div class="inputbox mx-1" style="flex: 1;">
              <table class="table  border-sm table-bordered " id="consumerProperty" style="width:630px;">
                <thead>
                  <tr>
                    <th style="font-size: large;"><b>Serial No.</b></th>
                    <th style="font-size: large;">Customer Name</th>
                    <th style="font-size: large;">Insurance Type</th>
                    <th style="font-size: large;">Property Type</th>
                    <th style="font-size: large;"> View Property</th>
                    <th style="font-size: large;">Update Property</th>
                  </tr>
                </thead>
                <tbody>


                  <c:forEach var="businessproperty" items="${businessPropertyDetails}" varStatus="loop">
                    <tr>
                      <td>${loop.index+1}</td>
                      <td>${businessproperty.consumerName}</td>
                      <td>${businessproperty.insuranceType}</td>
                      <td>${businessproperty.propertyType}</td>
                      <td><a class="btn btn-primary" style="background-color: white;font-weight: 700;color: green;"
                          href="/consumer/viewconsumerproperty?consumerId=${businessproperty.consumerId}&propertyId=${businessproperty.propertyId}">View</a>
                      </td>
                      <td><a class="btn btn-primary" style="background-color: white;font-weight: 700;color: green;"
                          href="/consumer/updateconsumerproperty?consumerId=${businessproperty.consumerId}&propertyId=${businessproperty.propertyId}">Update</a>
                      </td>
                    </tr>
                  </c:forEach>
                </tbody>

                <button type="button" class="btn btn-outline-success" onclick="exportDataInExcel('xlsx')"
                                    style="float: right;">Download .xlsx File</button>
                                <button type="button" class="btn btn-outline-success" onclick="exportDataInCSV()"
                                    style="float: right;">Download .csv File</button>
                                   </table>


            </div>

          </div>

          



          </div>

          <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>

          
          <script>
            function exportDataInCSV() {
              /* Get the HTML data using Element by Id */
              var table = document.getElementById("consumerProperty"); /* Declaring array variable */
              var rows = []; //iterate through rows of table
              for (var i = 0, row; row = table.rows[i]; i++) {
                //rows would be accessed using the "row" variable assigned in the for loop
                //Get each cell value/column from the row
                column1 = row.cells[0].innerText;
                column2 = row.cells[1].innerText;
                column3 = row.cells[2].innerText; /* add a new records in the array */
                rows.push([column1, column2, column3]);
              }
              csvContent = "data:text/csv;charset=utf-8,";
              /* add the column delimiter as comma(,) and each row splitted by new line character (\n) */
              rows.forEach(function (rowArray) {
                row = rowArray.join(",");
                csvContent += row + "\r\n";
              }); /* create a hidden <a> DOM node and set its download attribute */
              var encodedUri = encodeURI(csvContent);
              var link = document.createElement("a");
              link.setAttribute("href", encodedUri);
              link.setAttribute("download", "Consumer_property_list.csv");
              document.body.appendChild(link);
              /* download the data file named "Stock_Price_Report.csv" */
              link.click();
            }

            function exportDataInExcel(type, fn, dl) {
                            var elt = document.getElementById('consumerProperty');
                            var wb = XLSX.utils.table_to_book(elt, {
                                sheet: "sheet1"
                            });
                            return dl ? XLSX.write(wb, {
                                bookType: type,
                                bookSST: true,
                                type: 'base64'
                            }) : XLSX.writeFile(wb, fn
                                || ('Consumer_property_list.' + (type || 'xlsx')));
                        }
          </script>

         

        </body>

        </html>