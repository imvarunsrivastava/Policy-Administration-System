<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
  <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <!DOCTYPE html>
        <html lang="en">

        <head>
          <title>View Policy</title>
          <meta charset="utf-8">
          <meta name="viewport" content="width=device-width, initial-scale=1">
          <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        </head>

        <style>
          body {
            background-image: url("");
            background-repeat: no-repeat;
            background-size: 100%;

          }
          .heading{
            font-weight: 500;
            padding-left: 95px;
          }

         span{
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
            style="padding: 0px !important;width: 700px;">
            
            <div class="inputbox mx-2" style="flex: 1;">

              <h1 style="text-align: center; color:rgb(6, 37, 105);"><b>Policy Details</b></h1><br>

              <div class="form-group" style="color:midnightblue;">

                <table>
                  <tr>
                    <td class="heading">Consumer ID:</td>
                    <td>
                      <span>${policyDetailsResponse.consumerId}</span>
                    </td>
                  </tr>

                  <tr>
                    <td class="heading">Policy ID:</td>
                    <td>
                      <span>${policyDetailsResponse.policyId}</span>
                    </td>
                  </tr>

                  <tr>
                    <td class="heading">Business ID:</td>
                    <td>
                      <span>${policyDetailsResponse.businessId}</span>
                    </td>
                  </tr>
                  <tr>
                    <td class="heading">Property Type:</td>
                    <td>
                      <span>${policyDetailsResponse.propertyType}</span>
                    </td>
                  </tr>
                  <tr>
                    <td class="heading">Consumer Type:</td>
                    <td>
                      <span>${policyDetailsResponse.consumerType}</span>
                    </td>
                  </tr>
                  <tr>
                    <td class="heading">Assured Sum:</td>
                    <td>
                      <span>${policyDetailsResponse.assuredSum}</span>
                    </td>
                  </tr>
                  <tr>
                    <td class="heading">Tenure:</td>
                    <td>
                      <span>${policyDetailsResponse.tenure}</span>
                    </td>
                  </tr>
                  <tr>
                    <td class="heading">Business Value:</td>
                    <td>
                      <span>${policyDetailsResponse.businessValue}</span>
                    </td>
                  </tr>
                  <tr>
                    <td class="heading">Property Value:</td>
                    <td>
                      <span>${policyDetailsResponse.propertyValue}</span>
                    </td>
                  </tr>
                  <tr>
                    <td class="heading">Base Location:</td>
                    <td>
                      <span>${policyDetailsResponse.baseLocation}</span>
                    </td>
                  </tr>
                  <tr>
                    <td class="heading">Type:</td>
                    <td>
                      <span>${policyDetailsResponse.type}</span>
                    </td>
                  </tr>
                  <tr>
                    <td class="heading">Payment Details:</td>
                    <td>
                      <span>${policyDetailsResponse.paymentDetails}</span>
                    </td>
                  </tr>
                  <tr>
                    <td class="heading">Acceptance Status:</td>
                    <td>
                      <span>${policyDetailsResponse.acceptanceStatus}</span>
                    </td>
                  </tr>
                  <tr>
                    <td class="heading">Policy Status:</td>
                    <td>
                      <span>${policyDetailsResponse.policyStatus}</span>
                    </td>
                  </tr>
                  <tr>
                    <td class="heading">Effective Date:</td>
                    <td>
                      <span>${policyDetailsResponse.effectiveDate}</span>
                    </td>
                  </tr>
                  <tr>
                    <td class="heading">Covered Sum:</td>
                    <td>
                      <span>${policyDetailsResponse.coveredSum}</span>
                    </td>
                  </tr>
                  <tr>
                    <td class="heading">Duration:</td>
                    <td>
                      <span>${policyDetailsResponse.duration}</span>
                    </td>
                  </tr>
                  <tr>
                    <td class="heading">Accepted Quote:</td>
                    <td>
                      <span>${policyDetailsResponse.acceptedQuote}</span>
                    </td>
                  </tr>

                </table>


              </div>
              <div class="text-center mt-3">

                <a type="button" href="/consumer/viewconsumerbusiness?consumerId=${policyDetailsResponse.consumerId}"
                  class="btn btn-danger">Back</a>
              </div>


            </div>
          </div>
        </body>

        </html>