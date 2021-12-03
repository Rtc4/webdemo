package d_com.Market;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "d/Market/buy",urlPatterns = {"/d/Market/buy"})
public class Buy extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("into buy-get");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset = utf-8");
        String[] names;
        String[] prices;
        String[] quantities;
        names = req.getParameterValues("name");
        prices = req.getParameterValues("price");
        quantities = req.getParameterValues("quantity");

        int count = names.length;
        Good[] goods = new Good[count];
        for(int i=0;i<count;i++){
            System.out.println(names[i]);
            System.out.println(prices[i]);
            System.out.println(Integer.valueOf(quantities[i],10));
            goods[i]=new Good.Builder(names[i]).SetQuantity(Integer.valueOf(quantities[i],10)).SetPrice(Double.valueOf(prices[i]))
                    .builder();
        }
        for(int i=0;i<count;i++){
            System.out.println("fff" + goods[i].getQuantity());
        }
        req.setAttribute("count",count);
        req.setAttribute("goods",goods);
        req.setAttribute("length",goods.length);
        req.getRequestDispatcher("sellFinish.jsp").forward(req,resp);

//        String s = "<!DOCTYPE html>\n" +
//                "<html lang=\"en\">\n" +
//                "<head>\n" +
//                "    <meta charset=\"UTF-8\">\n" +
//                "    <title>购物</title>\n" +
//                "    <style>\n" +
//                "        .header{\n" +
//                "            /*background-color: #f1f1f1;*/\n" +
//                "            padding: 20px;\n" +
//                "            text-align: center;\n" +
//                "        }\n" +
//                "        ul {\n" +
//                "            list-style-type: none;\n" +
//                "            margin: 0;\n" +
//                "            padding: 0;\n" +
//                "            overflow: hidden;\n" +
//                "            background-color: #333;\n" +
//                "        }\n" +
//                "\n" +
//                "        li {\n" +
//                "            float: left;\n" +
//                "        }\n" +
//                "\n" +
//                "        li a {\n" +
//                "            display: block;\n" +
//                "            color: white;\n" +
//                "            text-align: center;\n" +
//                "            padding: 14px 16px;\n" +
//                "            text-decoration: none;\n" +
//                "        }\n" +
//                "\n" +
//                "        li a:hover {\n" +
//                "            background-color: #111;\n" +
//                "        }\n" +
//                "        .left_float{\n" +
//                "            float: left;\n" +
//                "            width: 350px;\n" +
//                "        }\n" +
//                "    </style>\n" +
//                "</head>\n" +
//                "<link href=\"./bootstrap-5.1.3-dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n" +
//                "<script src=\"./bootstrap-5.1.3-dist/js/bootstrap.bundle.min.js\" ></script>\n" +
//                "<body>\n" +
//                "<ul>\n" +
//                "    <li><a class=\"active\" href=\"#home\">主页</a></li>\n" +
//                "    <li><a href=\"#news\">功能</a></li>\n" +
//                "    <li><a href=\"#contact\">联系</a></li>\n" +
//                "    <li><a href=\"#about\">关于</a></li>\n" +
//                "</ul>\n" +
//                "<div style=\"clear: both\">    </div>\n" +
//                "<div class=\"header\">\n" +
//                "    <br><br>\n" +
//                "    <h2>商品清单</h2><br>\n" +
//                "    <div style=\"clear: both;\"> </div>\n" +
//                "    <hr>\n" +
//                "</div>\n" +
//                "<div style=\"margin: 30px 30%;\">\n" +
//                "    <div style=\"text-align: center\">\n" +
//                "        <table class=\"table\" align=\"center\" width=\"90%\">\n" +
//                "            <tr>\n" +
//                "                <td>商品名</td>\n" +
//                "                <td>单价</td>\n" +
//                "                <td>数量</td>\n" +
//                "                <td>价格</td>\n" +
//                "            </tr>\n" +
//                "\n" ;
//        double cost=0;
//        for(int i=0;i<count;i++){
//            System.out.println(goods[i].getName());
//            System.out.println(goods[i].getPrice());
//            System.out.println(goods[i].getQuantity());
//            if(goods[i].getQuantity()!=0){
//                s =s + "            <tr>\n" +
//                        "                <td>"+ goods[i].getName() +"</td>\n" +
//                        "                <td>"+ goods[i].getPrice() +"</td>\n" +
//                        "                <td>"+ goods[i].getQuantity() +"</td>\n" +
//                        "                <td>"+ goods[i].getPrice() * goods[i].getQuantity() +"</td>\n" +
//                        "            </tr>\n" ;
//                cost += goods[i].getPrice() * goods[i].getQuantity();
//            }
//        }
//
//
//        s +=    "        </table>\n" +
//                "<div style=\"float: right;clear:both;\">\n" +
//                "            总价"+cost+"\n" +
//                "        </div>" +
//                "    </div>\n" +
//                "</div>\n" +
//                "\n" +
//                "<div style=\"clear:both;\">    </div>\n" +
//                "<br>\n" +
//                "<hr style=\"margin: 10px\">\n" +
//                "<div align=\"center\" style=\"margin: 100px\">\n" +
//                "    <p>Copyright©2021</p>\n" +
//                "</div>\n" +
//                "\n" +
//                "</body>\n" +
//                "</html>";
//
//
//        ServletOutputStream out = resp.getOutputStream();
//        out.write(s.getBytes("utf-8"));



    }
}
