<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

        <!DOCTYPE html>
        <html lang="en">
  
        <head>
          <meta charset="UTF-8">
          <meta http-equiv="X-UA-Compatible" content="IE=edge">
          <meta name="viewport" content="width=device-width, initial-scale=1.0">
          <title>Create Consumer Property</title>
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
                    <img src="/images/Easy.png" alt="image" height="42px" width="42px">
                  </li>
                  <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#" style="color: rgb(236, 238, 226) ;">Easy
                      Policy</a>
                  </li>
  
  
                </ul>
                <ul class="d-flex navbar-nav  my-2 my-lg-0 navbar-nav-scroll" style="--bs-scroll-height: 100px;">
                  <li class="nav-item"><a href="/home" class="nav-link active " style="color: white;"
                      aria-current="page">Home</a></li>
  
                  <li class="nav-item"><a href="/home/about" class="nav-link active" aria-current="page"
                      style="color: white;">About</a></li>
  
                  <li class="nav-item"><a href="/home/contact" class="nav-link active" aria-current="page"
                      style="color: white;">Contact</a></li>
  
                  <li class="nav-item"><a href="/home/logout" class="nav-link active" aria-current="page"
                      style="color: white;">Logout</a></li>
                </ul>
              </div>
            </div>
          </nav>
        </head>
  
        <body>
  
            <div class="container d-flex justify-content-between border rounded shadow mt-1 "
            style="padding: 0px !important;height:auto ; width:auto ">
            <div class="img ">
              
            </div>
            <div class="inputbox mx-2" style="flex: 1;">
              <form:form action="/consumer/consumerproperty" method="POST" modelAttribute="businessPropertyRequest">
                <div>
                  <div class="row my-2">
                    <h1 style="text-align: center; color:rgb(6, 37, 105);font-size: 34px !important;
                    font-weight: 400 !important;">Create Consumer Property</h1>
                  </div>
                  <div class="row g-2 mb-3">
                    <div class="col-md">
                      <div class="form-floating">
                        <form:input path="consumerId" type="text" class="form-control" id="consumerId" placeholder="Enter Consumer ID"
                          name="consumerId" />
                        <label for="floatingInputGrid">Consumer ID</label>
                      </div>
                      <form:errors path="consumerId" cssClass="error" style="font-size:13px" />
                    </div>
                    <div class="col-md">
                      <div class="form-floating">
                        <form:input path="businessId" type="text" class="form-control" id="businessId" placeholder="Enter Business ID"
                          name="businessId" />
                        <label for="floatingInputGrid">Business ID</label>
                      </div>
                      <form:errors path="businessId" cssClass="error" style="font-size:13px" />
                    </div>
                  </div>
                  <div class="row g-2 mb-3">
                    <div class="col-md">
                      <div class="form-floating">
                        <form:input path="propertyType" type="text" class="form-control" id="propertyType" placeholder="Enter Property Type"
                          name="propertyType" />
                        <label for="floatingInputGrid">Property Type</label>
                      </div>
                      <form:errors path="propertyType" cssClass="error" style="font-size:13px" />
                    </div>
                    <div class="col-md">
                      <div class="form-floating">
                        <form:input path="insuranceType" type="text" class="form-control" id="insuranceType" placeholder="Enter Insurance Type"
                          name="insuranceType" />
                        <label for="floatingInputGrid">Insurance Type</label>
                      </div>
                      <form:errors path="insuranceType" cssClass="error" style="font-size:13px" />
                    </div>
                  </div>

                  <div class="row g-2 mb-3">
                    <div class="col-md">
                      <div class="form-floating">
                        <form:input path="buildingType" type="text" class="form-control" id="buildingType" placeholder="Enter Building Type"
                          name="buildingType" />
                        <label for="floatingInputGrid">Building Type</label>
                      </div>
                      <form:errors path="buildingType" cssClass="error" style="font-size:13px" />
                    </div>
                    <div class="col-md">
                      <div class="form-floating">
                        <form:input path="buildingSqft" type="text" class="form-control" id="buildingSqft" placeholder="Enter Building Sqft"
                          name="buildingSqft" />
                        <label for="floatingInputGrid">Building Sqft</label>
                      </div>
                      <form:errors path="buildingSqft" cssClass="error" style="font-size:13px" />
                    </div>
                  </div>

                  <div class="row g-2 mb-3">
                    <div class="col-md">
                      <div class="form-floating">
                        <form:input path="buildingStoreys" type="text" class="form-control" id="buildingStoreys" placeholder="Enter Building Storeys"
                          name="buildingStoreys" />
                        <label for="floatingInputGrid">Building Storeys</label>
                      </div>
                      <form:errors path="buildingStoreys" cssClass="error" style="font-size:13px" />
                    </div>
                    <div class="col-md">
                      <div class="form-floating">
                        <form:input path="buildingAge" type="text" class="form-control" id="buildingAge" placeholder="Enter Building Age"
                          name="buildingAge" />
                        <label for="floatingInputGrid">Building Age</label>
                      </div>
                      <form:errors path="buildingAge" cssClass="error" style="font-size:13px" />
                    </div>
                  </div>

                  <div class="row g-2 mb-3">
                    <div class="col-md">
                      <div class="form-floating">
                        <form:input path="costOfTheAsset" type="text" class="form-control" id="costOfTheAsset" placeholder="Enter Cost Of The Asset"
                          name="costOfTheAsset" />
                        <label for="floatingInputGrid">Cost Of The Asset</label>
                      </div>
                      <form:errors path="costOfTheAsset" cssClass="error" style="font-size:13px" />
                    </div>
                    <div class="col-md">
                      <div class="form-floating">
                        <form:input path="salvageValue" type="text" class="form-control" id="salvageValue" placeholder="Enter Salvage Value"
                          name="salvageValue" />
                        <label for="floatingInputGrid">Salvage Value</label>
                      </div>
                      <form:errors path="salvageValue" cssClass="error" style="font-size:13px" />
                    </div>
                  </div>

                  <div class="row g-2 mb-3">
                    <div class="col-md">
                      <div class="form-floating">
                        <form:input path="usefulLifeOfTheAsset" type="text" class="form-control" id="usefulLifeOfTheAsset" placeholder="Enter Building Storeys"
                          name="usefulLifeOfTheAsset" />
                        <label for="floatingInputGrid">Useful Life Of The Asset</label>
                      </div>
                      <form:errors path="usefulLifeOfTheAsset" cssClass="error" style="font-size:13px" />
                    </div>
                    <div class="col-md">
                        <div class="form-floating">
                         
                          <label for="floatingInputGrid"></label>
                        </div>
                       
                      </div>
                  </div>

                        
                  <div class="row g-2  mb-0">
                    <div class="col-md">
                      <a href="/home/propertyoption" class="btn btn-danger" role="button">Back</a>
  
                    </div>
                    <div class="col-md">
  
                      <div class="text-center"><button type="submit" class="btn btn-success">Create</button></div>
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