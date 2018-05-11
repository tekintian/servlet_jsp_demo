<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculation count</title>
    <link href="https://cdn.bootcss.com/bootstrap/4.1.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container" style="margin: 2rem auto 1rem;">
    <form action="<%=request.getServletContext().getInitParameter("HOME_URL") %>Calculation.do" method="post">
        <div class="form-group">
            <label for="num1" class="col-sm-2 control-label">第一个数</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="num1" name="num1" required="required"
                       placeholder="请输入待运算的第一个数">
            </div>
        </div>
        <div class="form-group">
            <label for="num2" class="col-sm-2 control-label">第二个数</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="num2" name="num2" required="required"
                       placeholder="请输入待运算的第二个数">
            </div>
        </div>

        <div>
            运算方式:
            <label class="radio-inline">
                <input type="radio" name="oper" value="+" checked="checked">加
            </label>
            <label class="radio-inline">
                <input type="radio" name="oper" value="-">减
            </label>
            <label class="radio-inline">
                <input type="radio" name="oper" value="*">乘
            </label>
            <label class="radio-inline">
                <input type="radio" name="oper" value="/">除
            </label>
        </div>

        <BR>
        <input type="submit" name="开始计算" class="btn btn-primary btn-lg">
    </form>
</div>
</body>
</html>
