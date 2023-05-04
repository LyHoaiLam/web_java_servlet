<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Facebook</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js" integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz" crossorigin="anonymous"></script>
    <style>


        .login_form_wrapper {
            float: left;
            width: 100%;
            padding-top: 40px;
            padding-bottom: 100px;
            background-color:grey;
        }
        
        .login_wrapper {
            padding-bottom: 20px;
            margin-bottom: 20px;
            border-bottom: 1px solid #e4e4e4;
            float: left;
            width: 100%;
            background: #fff;
            padding: 50px;
        }
        
        .login_wrapper a.btn {
            color: #fff;
            width: 100%;
            height: 50px;
            padding: 6px 25px;
            line-height: 36px;
            margin-bottom: 20px;
            text-align: left;
            border-radius: 5px;
            background: #4385f5;
            font-size: 16px;
            border: 1px solid #4385f5;
        }
        
        
        .login_wrapper a i {
            float: right;
            margin: 0;
            line-height: 35px;
        }
        
        .login_wrapper a.google-plus {
            background: #db4c3e;
            border: 1px solid #db4c3e;
        }
        
        .login_wrapper h2 {
            font-size: 18px;
            font-weight: 500;
            margin-bottom: 20px;
            color: #111;
            line-height: 20px;
            text-transform: uppercase;
            text-align: center;
            position: relative;
        }
        
        .login_wrapper .formsix-pos, .formsix-e {
            position: relative;
        }
        
        .form-group {
            margin-bottom: 15px;
        }
        
        .login_wrapper .form-control {
            height: 53px;
            padding: 15px 20px;
            font-size: 14px;
            line-height: 24px;
            border: 1px solid #fafafa;
            border-radius: 3px;
            box-shadow: none;
            font-family: 'Roboto';
            -webkit-transition: all 0.3s ease 0s;
            -moz-transition: all 0.3s ease 0s;
            -o-transition: all 0.3s ease 0s;
            transition: all 0.3s ease 0s;
            background-color: #fafafa;
        }
        
        .login_wrapper .form-control:focus {
            color: #999;
            background-color: fafafa;
            border: 1px solid #4285f4 !important;
        }
        
        .login_remember_box {
            margin-top: 30px;
            margin-bottom: 30px;
            color: #999;
        }
        
        .login_remember_box .control {
            position: relative;
            padding-left: 20px;
            cursor: pointer;
            font-size: 12px;
            font-weight: 500;
            margin: 0;
        }
        
        .login_remember_box .control input {
            position: absolute;
            z-index: -1;
            opacity: 0;
        }
        
        .login_remember_box .control__indicator {
            position: absolute;
            top: 0;
            left: 0;
            width: 15px;
            height: 15px;
            background: #fff;
            border: 1px solid #999;
        }
        
        .login_remember_box .forget_password {
            float: right;
            color: #db4c3e;
            line-height: 12px;
            text-decoration: underline;
        }
        
        .login_btn_wrapper {
            padding-bottom: 20px;
            margin-bottom: 30px;
            border-bottom: 1px solid #e4e4e4;
        }
        
        .login_btn_wrapper a.login_btn {
            text-align: center;
            text-transform: uppercase;
        }
        
        .login_message p {
            text-align: center;
            font-size: 16px;
            margin: 0;
        }
        
        p {
            color: #999999;
            font-size: 14px;
            line-height: 24px;
        }
        
        .login_wrapper a.login_btn:hover {
            background-color: #2c6ad4;
            border-color: #2c6ad4;
        }
        
        .login_wrapper a.btn:hover {
            background-color: #2c6ad4;
            border-color: #2c6ad4;
        }
        
        .login_wrapper a.google-plus:hover {
            background: #bd4033;
            border-color: #bd4033;
        }


    </style>
</head>
<body>
   <div class="container">
    <form action="RegisterAccountFaceBook" method="POST">
        <div class="login_form_wrapper">
            <div class="container">
                <div class="row">
                    <div class="col-md-8 col-md-offset-2">
                        <!-- login_wrapper -->
                        <div class="login_wrapper">
                            <!-- <div class="row">
                                <div class="col-lg-6 col-md-6 col-xs-12 col-sm-6">
                                    <a href="#" class="btn btn-primary facebook"> <span>Login with Facebook</span> <i class="fa fa-facebook"></i> </a>
                                </div>
                                <div class="col-lg-6 col-md-6 col-xs-12 col-sm-6">
                                    <a href="#" class="btn btn-primary google-plus"> Login  with Google <i class="fa fa-google-plus"></i> </a>
                                </div>
                            </div> -->
                         
                            <div class="formsix-pos">
                                <div class="form-group i-email">
                                    <h1>FaceBook</h1>
                                </div>
                                <div class="form-group i-email">
                                    <input type="text" class="form-control" required="" id="username" name="username" placeholder="Tài khoản">
                                </div>
                            </div>
                            <div class="formsix-e">
                                <div class="form-group i-password">
                                    <input type="password" class="form-control" required="" id="password" name="password" placeholder="Mật khẩu">
                                </div>
                            </div>
                            <div class="login_remember_box">
                                <label class="control control--checkbox">Remember me
                                    <input type="checkbox">
                                    <span class="control__indicator"></span>
                                </label>
                                <a href="#" class="forget_password">
                                    Forgot Password
                                </a>
                            </div>
                            <div class="login_btn_wrapper">
                                <button class="w-100 btn btn-lg btn-primary" type="submit">Đăng nhập</button>
                            </div>
                           
                        </div>
                        <!-- /.login_wrapper-->
                    </div>
                </div>
            </div>
        </div>
    </form>
   </div>
</body>
</html>