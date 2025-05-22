# PPE Inventory Management System

This is a Java GUI application developed as a group project for the Object-Oriented Programming module (AAPP013-4-2-OOP) at Asia Pacific University. The system is designed to manage and track Personal Protective Equipment (PPE) inventory distributed to hospitals, while applying key Object-Oriented Programming principles.

## 👥 Group Members
- Paureen Tan Nie Nie (TP075914)
- Lim Chee Xuan (TP075916)

## 🧰 Features
### Admin:
- Login and logout
- User and entity management (Admin, Staff, Supplier, Hospital)
- PPE inventory management (Add, Update, Track low stock)
- Transaction records (Receive, Distribute)
- Report generation (Export to PDF)
- Activity logs

### Staff:
- Login and logout
- Modify personal details
- Manage inventory (Receive/Distribute PPE)
- View transactions
- Track inventory

## ⚙️ Technologies Used
- Java (JDK 17)
- Java Swing (GUI)
- JDateChooser (Calendar component)
- File I/O for data persistence (no database used)
- PDF export using iText

## 🧠 Object-Oriented Concepts Applied
- **Encapsulation:** All attributes are private with public getters/setters.
- **Abstraction:** GUI elements abstract internal logic.
- **Inheritance:** Subclasses like `User` inherit from base `Entity` class.
- **Polymorphism:** Overloaded methods (e.g., `compare()` in sorting) allow flexible functionality.

## 📁 Project Structure
- `model`: Data classes (User, Hospital, PPE, etc.)
- `gui`: GUI interfaces for admin and staff
- `configuration`: Utility classes (e.g., ID assignment, validation)
- `authentication`: Login system
- `txtFiles`: Text-based data storage

## 📖 User Manual
The system includes screenshots and instructions for all functions in the `Documentation.pdf`.

## 📌 Notes
- Initial inventory setup must be done during the first run.
- Users are locked out after 3 failed login attempts.
- All data is stored in `.txt` files, and PDF reports are generated using iText.

## 📄 License
This project is for academic purposes only.
