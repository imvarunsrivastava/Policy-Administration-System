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
          style="padding: 0px !important;height: 550px;width:600px;">
         
          <div class="inputbox mx-2" style="flex: 1;">

            <h1 style="text-align: center; color:rgb(4, 30, 90);margin-top: 15px;" ><b>Consumer Property Details</b></h1><br>

            <div class="form-group" style="color:midnightblue; margin-left: 20px; margin-top: 30px;" >



              <table>
                <tr>
                  <td class="heading">Customer ID:</td>
                  <td>
                    <span>${businessPropertyDetails.consumerId}</span>
                  </td>
                </tr>

                <tr>
                  <td class="heading">Property ID:</td>
                  <td>
                    <span>${businessPropertyDetails.propertyId}</span>
                  </td>
                </tr>

                <tr>
                  <td class="heading">Business ID:</td>
                  <td>
                    <span>${businessPropertyDetails.businessId}</span>
                  </td>
                </tr>


                <tr>
                  <td class="heading">Consumer Name:</td>
                  <td>
                    <span>${businessPropertyDetails.consumerName}</span>
                  </td>
                </tr>

                <tr>
                  <td class="heading">Insurance Type :</td>
                  <td>
                    <span>${businessPropertyDetails.insuranceType}</span>
                  </td>
                </tr>

                <tr>
                  <td class="heading">Property Type:</td>
                  <td>
                    <span>${businessPropertyDetails.propertyType}</span>
                  </td>
                </tr>
                <tr>
                  <td class="heading">Building Sqft:</td>
                  <td>
                    <span>${businessPropertyDetails.buildingSqft}</span>
                  </td>
                </tr>
                <tr>
                  <td class="heading">Building Type:</td>
                  <td>
                    <span>${businessPropertyDetails.buildingType}</span>
                  </td>
                </tr>

                <tr>
                  <td class="heading">Building Storeys:</td>
                  <td>
                    <span>${businessPropertyDetails.buildingStoreys}</span>
                  </td>
                </tr>

                <tr>
                  <td class="heading">Building Age:</td>
                  <td>
                    <span>${businessPropertyDetails.buildingAge}</span>
                  </td>
                </tr>
                <tr>
                  <td class="heading">Cost Of The Asset:</td>
                  <td>
                    <span>${businessPropertyDetails.costOfTheAsset}</span>
                  </td>
                </tr>
                <tr>
                  <td class="heading">Salvage Value:</td>
                  <td>
                    <span>${businessPropertyDetails.salvageValue}</span>
                  </td>
                </tr>

                <tr>
                  <td class="heading">Useful Life Of The Asset:</td>
                  <td>
                    <span>${businessPropertyDetails.usefulLifeOfTheAsset}</span>
                  </td>
                </tr>

              </table>
              <table style="margin-top: 25px;margin-left: 94px;">
                <tr>
                  <td>
                    <a href="/consumer/viewconsumerpropertylist" class="btn btn-danger" role="button">Back</a>
                  </td>
                </tr>
              </table>
            </div>
          </div>



        </div>


        </div>
      </body>

      </html>