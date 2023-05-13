<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.lang.Math"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Processing Computer Purchases</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.min.js" integrity="sha384-heAjqF+bCxXpCWLa6Zhcp4fu20XoNIA98ecBC1YkdXhszjoejr5y9Q77hIrv8R9i" crossorigin="anonymous"></script>
</head>
<body>
    <%
        double tongTien = 0;
        String processor = request.getParameter("processor");
        
        double processorPrice = 0;

        if(processor != null){
            if(processor.equals("Core I9")){
                processorPrice = 5000000;
            }else if(processor.equals("Core I7")){
                processorPrice = 4000000;
            }else if(processor.equals("Core I5")){
                processorPrice = 3000000;
            }
            tongTien += processorPrice;
        }
        String ram = request.getParameter("ram");
        double ramPrice = 0;
        if(ram != null){
            if(ram.equals("Ram 8GB")){
                ramPrice = 500000;
            }else if(ram.equals("Ram 16GB")){
                ramPrice = 1000000;
            }
            tongTien += ramPrice;
        }
        String monitor = request.getParameter("monitor");
        double monitorPrice = 0;
        if(monitor != null){
            monitorPrice = 1500000;
        }
        tongTien += monitorPrice;
        String[] accessories = request.getParameterValues("accessories");
        if(accessories != null){
            for(String luaChon: accessories){
                if(luaChon.equals("Camera")){
                    tongTien += 800000;
                }
                if(luaChon.equals("Scanner")){
                    tongTien += 1500000;
                }
                if(luaChon.equals("Printer")){
                    tongTien += 1500000;
                }
            }
        }
    
    %>

    <h1>Bill</h1>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Name Product</th>
                <th scope="col">Prince</th>              
            </tr>
            </thead>
            <tbody>
                <%
                    if(processor != null){
                %>
            <tr>            
                <td> <%= processor %></td>
                <td> <%= processorPrice %> </td>
            </tr>
            <% } %>
              <%
                    if(ram != null){
                %>
            <tr>       
                <td> <%= ram %></td>
                <td> <%= ramPrice %> </td>
            </tr>
            <% } %>

            <%
                if(monitor != null){
             %>
            <tr>       
                <td> <%= monitor %></td>
                <td> <%= monitorPrice %> </td>
            </tr>

            <% } %>

            <%
            if(accessories != null)
            for(String luaChon: accessories){
                double price = 0;
                if(luaChon.equals("Camera")){
                    price = 800000;
                }
                if(luaChon.equals("Printer")){
                    price = 15000000;
                }
                if(luaChon.equals("Scanner")){
                    price = 15000000;
                }
                %>
                <tr>
                    <td> <%= luaChon %></td>
                    <td> <%= price %></td>
                </tr>
                <%
            }
            %>
            <tr>
                <td>Tong Tien</td>
                <td> <%= tongTien %></td>
            </tr>
            


            </tbody>
        </table>
</body>
</html>