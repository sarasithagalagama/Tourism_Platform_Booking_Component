package servlet;

import handler.BookingFileHandler;
import model.Booking;
import model.GroupBooking;
import model.SoloBooking;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@WebServlet("/BookingServlet")
public class BookingServlet extends HttpServlet {
    private static final String PACKAGE_FILE =
            "C:\\Users\\ASUS\\OneDrive\\Desktop\\Tourism_Platform_Booking_Component\\BookingComponent\\src\\main\\resources\\packages.txt";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fullName = request.getParameter("fullName");
        String phoneNumber = request.getParameter("phoneNumber");
        String address = request.getParameter("address");
        String gender = request.getParameter("gender");
        String email = request.getParameter("email");
        String packageName = request.getParameter("packageName");
        String specialReq = request.getParameter("specialRequirements");
        String bookingType = request.getParameter("bookingType");  // NEW
        int numberOfPeople = Integer.parseInt(request.getParameter("numberOfPeople"));

        // generate id & date
        String bookingId = BookingFileHandler.generateBookingId();
        String bookingDate = request.getParameter("bookingDate");
        String status = "Pending";

        // lookup price per unit
        double pricePerUnit = 0;
        try (BufferedReader rd = new BufferedReader(new FileReader(PACKAGE_FILE))) {
            String ln;
            while ((ln = rd.readLine()) != null) {
                String[] p = ln.split(",", 5);
                if (p.length >= 4 && p[1].equals(packageName)) {
                    pricePerUnit = Double.parseDouble(p[3]);
                    break;
                }
            }
        }

        // create booking object dynamically
        Booking booking;
        if ("solo".equalsIgnoreCase(bookingType)) {
            booking = new SoloBooking(
                    bookingId, fullName, phoneNumber, address, gender,
                    email, packageName, bookingDate, status, specialReq, 0
            );
        } else {
            booking = new GroupBooking(
                    bookingId, fullName, phoneNumber, address, gender,
                    email, packageName, bookingDate, status, specialReq, numberOfPeople, 0
            );
        }

        booking.calculateTotalPrice(pricePerUnit);

        BookingFileHandler.addBooking(booking);

        String source = request.getParameter("source");

        if ("user".equals(source)) {
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().write("success");
        } else {
            request.setAttribute("newTotalPrice", booking.getTotalPrice());
            request.setAttribute("success", true);
            request.setAttribute("fullName", fullName);
            request.getRequestDispatcher("/jsp/bookingSuccess.jsp").forward(request, response);
        }


    }
}
