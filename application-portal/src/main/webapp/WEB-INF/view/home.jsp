<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page</title>
    <link rel="stylesheet" href="/css/nav.css">
    
    <nav class="navbar" style="font-family: 'Times New Roman', Times, serif; ">

      <h1><a class="navbar" style="color: rgb(236, 238, 226) ;margin-left: 30px; margin-top: -1px;">Easy Policy</a></h1>

  <span><img src="/images/Easy.png" class ="img" alt="image" style="margin-left:-520px" height="42px" width="42px" ></span>

      <ul class="nav-links" >

        <div class="menu">

          <li><a href="/home">Home</a></li>

          <li><a href="/home/about">About</a></li>

          <li><a href="/home/contact">Contact</a></li>

          <li><a class="b1" href="/home/logout">Logout</a></li>

        </div>

      </ul>

    </nav>
</head>
<body>
    <div>
  
    <img id="image" src="https://th.bing.com/th/id/OIP.p9Dr7DcdHX9de2kK-x00wgHaFi?w=249&h=186&c=7&r=0&o=5&dpr=1.5&pid=1.7" alt="" />
    </div>
    <div id="child-box"></div>
    <div id="box">
      <div id="pink">EASY POLICY</div>
      <div id="blackbold">
        We administer your<br />
        Policies
      </div>
      <div id="small" style="color:rgb(2, 13, 58);">
        <p>
          We are a leading insurance management organization offers business insurance that protects
          businesses from losses due to events that may occur during the normal course of business.
          There are many types of insurance we provide for businesses including coverage for
          property damage, legal liability and employee-related risks.
        </p>
      </div>
      <a href="/home/businessoption">
      <button id="b2" type="button">Business</button>
    </a>
    <a href="/home/propertyoption">
      <button id="b2" type="button">Properties</button>
    </a>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
          integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
          crossorigin="anonymous"></script>
  </body>
</html>
