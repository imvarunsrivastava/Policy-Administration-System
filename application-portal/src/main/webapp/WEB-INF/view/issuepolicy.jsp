<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


                <!DOCTYPE html>
                <html lang="en">

                <head>
                    <title>Issue Policy</title>
                    <meta charset="utf-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1">
                    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
                        rel="stylesheet"
                        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
                        crossorigin="anonymous">
                </head>

                <style>
                    body {
                        background-image: url("");
                        background-repeat: no-repeat;
                        background-size: 100%;

                    }

                    .error {
                        color: #ff0000;
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
                        style="padding: 0px !important;height: 400px;width: 450px;">
                        
                        <div class="inputbox mx-2" style="flex: 1;">

                            <h1 style="text-align: center; color:rgb(6, 37, 105);"><b>Issue Policy</b></h1><br>
                            <form:form action="/policy/issuepolicy" method="POST" modelAttribute="issuePolicyRequest">
                                <div class="form-group" style="color:midnightblue;">
                                    <form:input path="consumerId" type="hidden" value="${consumerId}" />

                                    <div class="row g-2  mb-3">
                                        <div class="col-md">
                                            <div class="form-floating">
                                                <form:input path="paymentDetails" type="text" class="form-control"
                                                    id="paymentDetails" placeholder="Enter Payment Details"
                                                    name="paymentDetails" />
                                                <label for="floatingInputGrid">Payment Details</label>
                                            </div>
                                            <form:errors path="paymentDetails" cssClass="error"
                                                style="font-size:13px" />
                                        </div>
                                    </div>

                                    <div class="row g-2  mb-3">
                                        <div class="col-md">
                                            <div class="form-floating">
                                                <form:input path="acceptanceStatus" type="text" class="form-control"
                                                    id="acceptanceStatus" placeholder="Enter Acceptance Status<"
                                                    name="acceptanceStatus" />
                                                <label for="floatingInputGrid">Acceptance Status</label>
                                            </div>
                                            <form:errors path="acceptanceStatus" cssClass="error"
                                                style="font-size:13px" />
                                        </div>
                                    </div>

                                    <div class="row g-2  mb-0">
                                        <div class="col-md">
                                            <div class="text-center"><a href="/consumer/viewconsumerbusiness?consumerId=${consumerId}"
                                                class="btn btn-danger" role="button">Back</a></div> 

                                        </div>
                                        <div class="col-md">

                                            <div class="text-center"><button type="submit" class="btn btn-success">Issue
                                                    Policy</button></div>
                                        </div>
                                    </div>


                            </form:form>

                        </div>
                    </div>
                </body>

                </html>