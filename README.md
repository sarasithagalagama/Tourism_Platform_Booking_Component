# Booking Management Component

A modular web-based booking system developed using **Java**, **JSP**, and **Object-Oriented Programming**. This project demonstrates the use of inheritance, polymorphism, form handling, and modern JSP UI design in a real-world scenario.

## 🛠️ Tech Stack

- Java
- JSP (JavaServer Pages)
- HTML/CSS
- Servlet API
- File I/O (for persistence)
- MVC Architecture

## 📌 Features

- ✅ Dynamic booking form for both solo and group bookings
- ✅ Polymorphic class hierarchy using `Booking`, `SoloBooking`, and `GroupBooking`
- ✅ Real-time form validation and success modals (no page reload)
- ✅ Responsive and clean UI using CSS variables
- ✅ File-based serialization and deserialization with polymorphic support
- ✅ Admin view for managing and viewing bookings

## 🧱 Class Structure
Booking (abstract)
├── SoloBooking
└── GroupBooking


Each subclass overrides methods such as `calculateTotalPrice()` and includes specific logic based on the booking type.

## 📁 Project Modules

- `/model` – Java classes for `Booking`, `SoloBooking`, `GroupBooking`
- `/servlets` – Handles booking submissions and routing
- `/jsp` – UI views with dynamic forms and validation
- `/css` – Custom styling with variables for theme consistency
- `/data` – Serialized file storage for bookings

## 📸 Screenshots

![screencapture-localhost-8080-BookingComponent-war-exploded-BookingHistoryServlet-2025-07-02-14_16_23](https://github.com/user-attachments/assets/b6c4f778-ba46-48d7-bacc-5d6dd225fa92)


## 🚀 How to Run

1. Clone the repository
2. Open in an IDE (e.g., IntelliJ, Eclipse)
3. Deploy using a servlet container (Apache Tomcat)
4. Navigate to `http://localhost:8080/bookingform.jsp`

## 📖 Learning Objectives

- Apply core OOP principles in Java
- Build modular, scalable components
- Handle user input with JSP forms and server-side processing
- Implement basic file persistence

## 🙋‍♂️ Author

**Sarasitha Galagama**  
IT Undergraduate at SLIIT  
📧 sarasithagalagama@gmail.com  
🔗 [LinkedIn]([https://www.linkedin.com/in/your-profile](https://www.linkedin.com/in/sarasitha-galagama/))

---

