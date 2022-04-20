<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

        <!DOCTYPE html>
        <html lang="en">

        <head>
          <title>Error</title>
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

          .error {
            color: #ff0000;
          }

          .con {
            height: 200px;
            width: 400px;
            position: fixed;
            top: 50%;
            left: 50%;
            margin-top: -100px;
            margin-left: -200px;
          }

          .wrapper {
            max-width: 600px;
            min-height: 200px;
            margin: 80px auto;
            padding: 40px 30px 30px 30px;
            background-color: rgba(190, 179, 241, 0.822);
            border-radius: 15px;
            box-shadow: 4px 3px 8px 1px #969696;
            -webkit-box-shadow: 4px 3px 8px 1px #969696;

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
                <div class="container">
                    <h1 style="text-align: center; color:rgb(105, 6, 6);"><b>${error}</b></h1>
                </div>

            </body>

            </html>