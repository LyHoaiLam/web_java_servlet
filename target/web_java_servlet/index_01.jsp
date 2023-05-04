<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang Mua Hàng JSP</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.min.js" integrity="sha384-heAjqF+bCxXpCWLa6Zhcp4fu20XoNIA98ecBC1YkdXhszjoejr5y9Q77hIrv8R9i" crossorigin="anonymous"></script>
</head>
<body>
    <form action="index_02.jsp" method="Get">
        <div class="mb-3">
            <label for="hoVaTen" class="form-label">Ho Va Ten</label>
            <input type="text" class="form-control" id="hoVaTen" aria-describedby="emailHelp" name="hoVaTen">
            <div class="form-text"></div>
          </div>
        <div class="mb-3">
          <label for="exampleInputEmail1" class="form-label">Email</label>
          <input type="email" class="form-control" id="emaiil" aria-describedby="emailHelp" name="email">
          <div id="emailHelp" class="form-text"></div>
        </div>
        <div class="mb-3">
            <label for="soLuong" class="form-label">So Luong</label>
            <input type="text" class="form-control" id="soLuong" aria-describedby="emailHelp" name="soLuong">
            <div class="form-text"></div>
          </div>

        <button type="submit" class="btn btn-primary">Dat Hang</button>
      </form>
</body>
</html>