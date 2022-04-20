<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
  <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

      <!DOCTYPE html>
      <html lang="en">

      <head>
        <title>Display Consumer Details</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://fonts.googleapis.com/css2?family=Playfair+Display:ital@1&display=swap" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
      </head>

      <style>
        body {
          background-image: url("");
          background-size: 100%;

        }



        .heading {
          font-weight: 500;
          padding-left: 95px;
        }

        span {
          margin-left: 100px;
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
          style="padding: 0px !important;height: 700px;width: 600px;">
          
          <div class="inputbox mx-2" style="flex: 1;">

            <h1 style="text-align: center; color:rgb(6, 37, 105);margin-top: 15px;"><b>Consumer Business Details</b></h1><br>

            <div class="form-group" style="color:midnightblue;margin-top: 30px;">


              <table>

                <tr>
                  <td class="heading">Customer ID:</td>
                  <td>
                    <span>${consumerBusinessDetails.consumerId}</span>
                  </td>
                </tr>
                <tr>
                  <td class="heading">Name:</td>
                  <td>
                    <span>${consumerBusinessDetails.name}</span>
                  </td>
                </tr>
                <tr>
                  <td class="heading">Date Of Birth:</td>
                  <td>
                    <span>${consumerBusinessDetails.dob}</span>
                  </td>
                </tr>
                <tr>
                  <td class="heading">Business Name:</td>
                  <td>
                    <span>${consumerBusinessDetails.businessName}</span>
                  </td>
                </tr>
                <tr>
                  <td class="heading">Pan Details:</td>
                  <td>
                    <span>${consumerBusinessDetails.panDetails}</span>
                  </td>
                </tr>
                <tr>
                  <td class="heading">Email:</td>
                  <td>
                    <span>${consumerBusinessDetails.email}</span>
                  </td>
                </tr>
                <tr>
                  <td class="heading">Phone:</td>
                  <td>
                    <span>${consumerBusinessDetails.phone}</span>
                  </td>
                </tr>
                <tr>
                  <td class="heading">Business Overview:</td>
                  <td>
                    <span>${consumerBusinessDetails.businessOverview}</span>
                  </td>
                </tr>
                <tr>
                  <td class="heading">Validity:</td>
                  <td>
                    <span>${consumerBusinessDetails.validity}</span>
                  </td>
                </tr>
                <tr>
                  <td class="heading">Agent Id:</td>
                  <td>
                    <span>${consumerBusinessDetails.agentId}</span>
                  </td>
                </tr>
                <tr>
                  <td class="heading">Agent Name:</td>
                  <td>
                    <span>${consumerBusinessDetails.agentName}</span>
                  </td>
                </tr>

                <tr>
                  <td class="heading">Business Id:</td>
                  <td>
                    <span>${consumerBusinessDetails.businessId}</span>
                  </td>
                </tr>
                <tr>
                  <td class="heading">Business Category:</td>
                  <td>
                    <span>${consumerBusinessDetails.businessCategory}</span>
                  </td>
                </tr>
                <tr>
                  <td class="heading">Business Type:</td>
                  <td>
                    <span>${consumerBusinessDetails.businessType}</span>
                  </td>
                </tr>
                <tr>
                  <td class="heading">Business TurnOver:</td>
                  <td>
                    <span>${consumerBusinessDetails.businessTurnover}</span>
                  </td>
                </tr>
                <tr>
                  <td class="heading">Capital Invested:</td>
                  <td>
                    <span>${consumerBusinessDetails.capitalInvested}</span>
                  </td>
                </tr>
                <tr>
                  <td class="heading">Total Employees:</td>
                  <td>
                    <span>${consumerBusinessDetails.totalEmployees}</span>
                  </td>
                </tr>
                <tr>
                  <td class="heading">Business Value:</td>
                  <td>
                    <span>${consumerBusinessDetails.businessValue}</span>
                  </td>
                </tr>
                <tr>
                  <td class="heading">Business Age:</td>
                  <td>
                    <span>${consumerBusinessDetails.businessAge}</span>
                  </td>
                </tr>
              </table>
              <table style="margin-top: 25px;">
                <tr>
                  <td style="padding-left: 70px;">
                    <a href="/consumer/viewconsumerbusinesslist" class="btn btn-danger" role="button">Back</a>
                  </td>
                  <td style="padding-left: 20px;">
                    <a href="/policy/createpolicy?consumerId=${consumerBusinessDetails.consumerId}" class="btn btn-success"
                      role="button">Create Policy</a>
                  </td>
                  <td style="padding-left: 20px;"><a href="/policy/issuepolicy?consumerId=${consumerBusinessDetails.consumerId}" class="btn btn-success"
                      role="button">Issue Policy</a></td>
                  <td style="padding-left: 20px;"><a href="/policy/viewpolicy?consumerId=${consumerBusinessDetails.consumerId}" class="btn btn-success"
                      role="button">View Policy</a></td>
                </tr>
              </table>
            </div>
          </div>


        

        </div>
      </body>

      </html>