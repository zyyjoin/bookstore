<%--
  Created by IntelliJ IDEA.
  User: 我的大神舟
  Date: 2017/9/20
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<script type="text/javascript">
    $(function () {
        $("a").click(function () {
            var serializeVal = $(":hidden").serialize();
            var href = this.href+"&"+serializeVal;
            window.location.href = href;
            return false;
        });
    });
</script>

<input type="hidden" name="minPrice" value="${param.minPrice}">
<input type="hidden" name="maxPrice" value="${param.maxPrice}">

