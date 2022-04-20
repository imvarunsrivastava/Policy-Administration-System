<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
  <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

      <!DOCTYPE html>
      <html lang="en">

      <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Consumer Business</title>
        <link href="https://fonts.googleapis.com/css2?family=Playfair+Display:ital@1&display=swap" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

        <style>
          * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
          }

          a {
            text-decoration: none;
          }

          li {
            list-style: none;
          }


          #b2 {
            /* margin-top: 20px; */
            width: 224px;
            height: 40px;
            background-color: white;
            border-radius: 20px;
            border-color: rgb(146, 39, 207);
            color: rgb(129, 83, 214);
            /* margin-left: 210px; */
          }


          #image {
            width: 31%;
            height: 50%;
            float: right;
            margin-right: 170px;
            margin-top: 5%;
          }

          #pink {
            color: rgb(105, 39, 180);
            font-size: large;
            margin-top: 20px;
            margin-left: 215px;
            font-size: 20px;
            margin-left: 118px;
          }

          p {
            margin-left: 215px;
          }

          #box {
            height: 500px;
            background-image: url("circle-image.jpeg");
          }

          #child-box {
            background-image: url("https://cdn2.vectorstock.com/i/1000x1000/88/66/group-life-insurance-icon-flat-design-vector-6268866.jpg");
            border: 30px;
          }

          #small {
            margin-left: 20%;
            margin-top: 130px;
            padding: 33px 20px 20px 20px;
            height: 35%;
            width: 20%;
            background-color: rgb(207, 157, 236);
            background-color: rgba(202, 169, 224, 0.822);
            /* background-color: #395b75; */
            border-radius: 15px;
            box-shadow: 4px 3px 8px 1px #01000a;
            -webkit-box-shadow: 4px 3px 8px 1px #070205;
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

        <div>
          
          <img id="image"
            src="https://th.bing.com/th/id/OIP.h3Vn9-KPU9kSyQoMLa_rGgHaF7?w=242&h=194&c=7&r=0&o=5&dpr=1.5&pid=1.7">
        </div>
        <div id="box">
          <div id="pink">Welcome to Busines Profile!!!!!</div>

          <div id="small">
            <a href="/consumer/consumerbusiness"><button id="b2" type="button">Create
                Consumer Business</button></a></br></br>
            <a href="/consumer/viewconsumerbusinesslist"><button id="b2" type="button">View
                Consumer Business</button></a>
            </p>
          </div>

        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
          integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
          crossorigin="anonymous"></script>
      </body>

      </html>