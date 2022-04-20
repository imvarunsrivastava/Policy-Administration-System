<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isErrorPage="true" %>
  <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

  <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Playfair+Display:ital@1&display=swap" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>Document</title>

    <style>
        * {
    padding: 0;
    margin: 0
}

.wrapper {
    height: 130px;
    display: flex;
    justify-content: center;
    align-items: center;
    background-color:white
}

.checkmark__circle {
    stroke-dasharray: 166;
    stroke-dashoffset: 166;
    stroke-width: 2;
    stroke-miterlimit: 10;
    stroke: #7ac142;
    fill: none;
    animation: stroke 0.6s cubic-bezier(0.65, 0, 0.45, 1) forwards
}

.checkmark {
    width: 120px;
    height: 120px;
    border-radius: 50%;
    display: block;
    stroke-width: 5;
    stroke: rgb(4, 0, 8);
    stroke-miterlimit: 10;
    margin: 10% auto;
    box-shadow: inset 0px 0px 0px #7ac142;
    animation: fill .4s ease-in-out .4s forwards, scale .3s ease-in-out .9s both
}

.checkmark__check {
    transform-origin: 50% 50%;
    stroke-dasharray: 48;
    stroke-dashoffset: 48;
    animation: stroke 0.3s cubic-bezier(0.65, 0, 0.45, 1) 0.8s forwards
}

@keyframes stroke {
    100% {
        stroke-dashoffset: 0
    }
}

@keyframes scale {

    0%,
    100% {
        transform: none
    }

    50% {
        transform: scale3d(1.1, 1.1, 1)
    }
}

@keyframes fill {
    100% {
        box-shadow: inset 0px 0px 0px 30px #7ac142
    }
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
   
    <h1 style="font-weight: bolder; padding-left:20% ; background-color:white;margin-top: 25px;">${status}</h1>

    <div class="wrapper"> <svg class="checkmark" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 52 52">
       
        <circle class="checkmark__circle" cx="26" cy="26" r="25" fill="none" />
        <path class="checkmark__check" fill="none" d="M14.1 27.2l7.1 7.2 16.7-16.8" />
    </svg>
</div>
    
</body>
</html>