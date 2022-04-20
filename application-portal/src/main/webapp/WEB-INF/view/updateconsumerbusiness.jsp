<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isErrorPage="true" %>
  <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

      <!DOCTYPE html>
      <html lang="en">

      <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Update Consumer Business</title>
        <!-- <link rel="stylesheet" href="/css/nav.css"> -->
        <link href="https://fonts.googleapis.com/css2?family=Playfair+Display:ital@1&display=swap" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <style>
          body {

            background-image: url("");

            background-repeat: no-repeat;

            background-size: 200%;

            height: 500px;

          }

          .error {
            color: red;
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
        <div class="container d-flex justify-content-between border rounded shadow mt-1 "
          style="padding: 0px !important;height: 700;">
          
          <div class="inputbox mx-2" style="flex: 1;">
            <form:form action="/consumer/updateconsumerbusiness" method="POST" modelAttribute="consumerBusinessDetails">
              <form:input path="consumerId" type="hidden" />
              <form:input path="businessId" type="hidden" />
              <form:input path="businessValue" type="hidden" />
              <div>
                <div class="row my-2">
                  <h1 style="text-align: center; color:rgb(6, 37, 105);font-size: 34px !important;
                  font-weight: 400 !important;font-weight: bold;">Update Consumer Business</h1>
                </div>
                <div class="row g-2 mb-3">
                  <div class="col-md">
                    <div class="form-floating">
                      <form:input path="name" type="text" class="form-control" id="name" placeholder="Enter Name"
                        name="name" />
                      <label for="floatingInputGrid">Name</label>
                    </div>
                    <form:errors path="name" cssClass="error" style="font-size:13px" />
                  </div>
                  <div class="col-md">
                    <div class="form-floating">
                      <form:input path="dob" type="date" class="form-control" id="dob" placeholder="Enter DOB"
                        name="dob" />
                      <label for="floatingInputGrid">Date Of Birth</label>
                    </div>
                    <form:errors path="dob" cssClass="error" style="font-size:13px" />
                  </div>
                </div>

                <div class="row g-2 mb-3">
                  <div class="col-md">
                    <div class="form-floating">
                      <form:input path="businessName" type="text" class="form-control" id="businessName"
                        placeholder="Enter Business Name" name="BusinessName" />
                      <label for="floatingInputGrid">Business Name</label>
                    </div>
                    <form:errors path="businessName" cssClass="error" style="font-size:13px" />
                  </div>
                  <div class="col-md">
                    <div class="form-floating">
                      <form:input path="panDetails" type="text" class="form-control" id="PAN"
                        placeholder="Enter PAN Details" name="PAN" />
                      <label for="floatingInputGrid">PAN Details</label>
                    </div>
                    <form:errors path="panDetails" cssClass="error" style="font-size:13px" />
                  </div>
                </div>
                <div class="row g-2 mb-3">
                  <div class="col-md">
                    <div class="form-floating">
                      <form:input path="email" type="email" class="form-control" id="email" placeholder="Enter email"
                        name="email" />
                      <label for="floatingInputGrid">Email</label>
                    </div>
                    <form:errors path="email" cssClass="error" style="font-size:13px" />
                  </div>
                  <div class="col-md">
                    <div class="form-floating">
                      <form:input path="phone" type="phone" class="form-control" id="phone"
                        placeholder="Enter Phone Number" name="phone" />
                      <label for="floatingInputGrid">Phone No.</label>
                    </div>
                    <form:errors path="phone" cssClass="error" style="font-size:13px" />
                  </div>
                </div>
                <div class="row g-2 mb-3">
                  <div class="col-md">
                    <div class="form-floating">
                      <form:input path="businessOverview" type="text" class="form-control" id="businessOverview"
                        placeholder="Enter Business Overview" name="businessOverview" />
                      <label for="floatingInputGrid">Business Overview</label>
                    </div>
                    <form:errors path="businessOverview" cssClass="error" style="font-size:13px" />
                  </div>
                  <div class="col-md">
                    <div class="form-floating">
                      <form:input path="validity" type="number" class="form-control" id="validity"
                        placeholder="Enter validity" name="validity" />
                      <label for="floatingInputGrid">Validity</label>
                    </div>
                    <form:errors path="validity" cssClass="error" style="font-size:13px" />
                  </div>
                </div>
                <div class="row g-2 mb-3">
                  <div class="col-md">
                    <div class="form-floating">
                      <form:input path="agentId" type="text" class="form-control" id="agentId"
                        placeholder="Enter Agent ID" name="agentId" />
                      <label for="floatingInputGrid">Agent Id</label>
                    </div>
                    <form:errors path="agentId" cssClass="error" style="font-size:13px" />
                  </div>
                  <div class="col-md">
                    <div class="form-floating">
                      <form:input path="agentName" type="text" class="form-control" id="agentName"
                        placeholder="Enter Agent Name" name="agentName" />
                      <label for="floatingInputGrid">Agent Name</label>
                    </div>
                    <form:errors path="agentName" cssClass="error" style="font-size:13px" />
                  </div>
                </div>
                <div class="row g-2 mb-3">
                  <div class="col-md">
                    <div class="form-floating">
                      <form:input path="businessCategory" type="text" class="form-control" id="businessCategory"
                        placeholder="Enter Business Category" name="businessCategory" />
                      <label for="floatingInputGrid">Business Category</label>
                    </div>
                    <form:errors path="businessCategory" cssClass="error" style="font-size:13px" />
                  </div>
                  <div class="col-md">
                    <div class="form-floating">
                      <form:input path="businessType" type="text" class="form-control" id="businessType"
                        placeholder="Enter Business Type" name="businessType" />
                      <label for="floatingInputGrid">Business Type</label>
                    </div>
                    <form:errors path="businessType" cssClass="error" style="font-size:13px" />
                  </div>
                </div>
                <div class="row g-2 mb-3">
                  <div class="col-md">
                    <div class="form-floating">
                      <form:input path="businessTurnover" type="text" class="form-control" id="businessTurnover"
                        placeholder="Enter Business Turnover" name="businessTurnover" />
                      <label for="floatingInputGrid">Business Turnover</label>
                    </div>
                    <form:errors path="businessTurnover" cssClass="error" style="font-size:13px" />
                  </div>
                  <div class="col-md">
                    <div class="form-floating">
                      <form:input path="capitalInvested" type="text" class="form-control" id="capitalInvested"
                        placeholder="Enter Capital Invested" name="capitalInvested" />
                      <label for="floatingInputGrid">Capital Invested</label>
                    </div>
                    <form:errors path="capitalInvested" cssClass="error" style="font-size:13px" />
                  </div>
                </div>
                <div class="row g-2 mb-3">
                  <div class="col-md">
                    <div class="form-floating">
                      <form:input path="totalEmployees" type="text" class="form-control" id="totalEmployees"
                        placeholder="Enter Total Employees" name="totalEmployees" />
                      <label for="floatingInputGrid">Total Employees</label>
                    </div>
                    <form:errors path="totalEmployees" cssClass="error" style="font-size:13px" />
                  </div>
                  <div class="col-md">
                    <div class="form-floating">
                      <form:input path="businessAge" type="text" class="form-control" id="businessAge"
                        placeholder="Enter Business Age" name="businessAge" />
                      <label for="floatingInputGrid">Business Age</label>
                    </div>
                    <form:errors path="businessAge" cssClass="error" style="font-size:13px" />
                  </div>
                </div>

                <div class="row g-2  mb-0">
                  <div class="col-md">
                    <div class="text-center"><a href="/consumer/viewconsumerbusinesslist" class="btn btn-danger" role="button">Back</a>
                    </div>
                  </div>
                  <div class="col-md">

                    <div class="text-center"><button type="submit" class="btn btn-success">Update</button></div>
                  </div>
                </div>


              </div>
            </form:form>

          </div>


        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
          integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
          crossorigin="anonymous"></script>
      </body>

      </html>