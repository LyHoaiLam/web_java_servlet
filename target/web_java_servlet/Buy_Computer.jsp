<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Buy A Computer</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.min.js" integrity="sha384-heAjqF+bCxXpCWLa6Zhcp4fu20XoNIA98ecBC1YkdXhszjoejr5y9Q77hIrv8R9i" crossorigin="anonymous"></script>
</head>
<body>
    <div class="container">

        <h1>Select the computer configuration you need to buy</h1>
        <hr>
        <form action="xuLy_MuaMayTinh.jsp">
            <h2>Processor</h2>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="processor" id="corei9" value="Core I9">
                <label class="form-check-label" for="corei9">
                  Core I9
                </label>
              </div>
              <div class="form-check">
                <input class="form-check-input" type="radio" name="processor" id="corei7" value="Core I7">
                <label class="form-check-label" for="corei7">
                  Core I7
                </label>
              </div>
              <div class="form-check">
                <input class="form-check-input" type="radio" name="processor" id="corei5" value="Core I5">
                <label class="form-check-label" for="corei5">
                  Core I5
                </label>
              </div>
              <h2>RAM</h2>
              <div class="form-check">
                <input class="form-check-input" type="radio" name="ram" id="ram8gb" value="Ram 8GB">
                <label class="form-check-label" for="ram8gb">
                  Ram 8GB
                </label>
              </div>
              <div class="form-check">
                <input class="form-check-input" type="radio" name="ram" id="ram16bg" value="Ram 16GB">
                <label class="form-check-label" for="ram16gb">
                  Ram 16GB
                </label>
              </div>
              <h2>Monitor</h2>
              <div class="form-check">
                <input class="form-check-input" type="checkbox" value="Monitor" id="monitor" name="monitor">
                <label class="form-check-label" for="monitor">
                    Monitor
                </label>
              </div>
              <h2>Accessories</h2>
              <select class="form-select" multiple aria-label="multiple select example" name="accessories">
               
                <option value="Camera">Camera</option>
                <option value="Printer">Printer</option>
                <option value="Scanner">Scanner</option>
              </select>
              <button class="btn btn-primary mt-2" type="submit">Buy</button>
        </form>
    </div>
</body>
</html>