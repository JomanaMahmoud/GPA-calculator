# GPA Calculator Android App

#### Description:
The GPA Calculator is a comprehensive Android application designed to help users calculate their Grade Point Average (GPA) with ease. This app offers a dynamic and user-friendly interface that allows for the addition and management of multiple courses. Users can input course details, calculate their GPA, and remove courses as needed. The application's flexible design ensures that it adapts to user interactions, providing a seamless experience.

### Features:
- **Dynamic Course Addition:** Users can add new courses dynamically by entering the course name, credit hours, and GPA. Each new course is displayed in a structured layout, adjusting automatically based on the number of courses added.
- **GPA Calculation:** The app calculates the GPA based on the entered course details. By clicking the "Calculate" button, users receive an accurate GPA based on the provided credit hours and GPA values.
- **Course Deletion:** Users can remove any course from the list using the "Delete" button associated with each course entry. This feature allows for easy management and adjustment of the course list.
- **Error Handling:** The app includes error handling to ensure that all required fields are completed before calculating the GPA. If any fields are left empty, users will be prompted to fill in all necessary information.

### Technologies Used:
- **Java:** The core programming language used for implementing the app’s logic. Java enables efficient and reliable functionality.
- **Android Studio:** The Integrated Development Environment (IDE) used for developing the application. Android Studio provides a comprehensive suite of tools for Android development.
- **ConstraintLayout:** Used for structuring the layout of the app, offering a flexible and adaptive design that accommodates various screen sizes and orientations.
- **LinearLayout:** Utilized for organizing dynamically added course inputs in a vertical manner, ensuring a clear and intuitive user interface.

### How It Works:
1. **Adding Courses:**
   - Click on the "Add Course" button to generate input fields for the course name, credit hours, and GPA. Each new course is displayed in a horizontal `LinearLayout` within the main content area.
   - The layout dynamically adjusts to accommodate the number of courses added, ensuring a clean and organized appearance.

2. **GPA Calculation:**
   - After entering course details, click the "Calculate" button to compute the GPA. The app aggregates the credit hours and GPA values, calculates the weighted average, and displays the result.
   - The calculation considers the total number of credit hours and the weighted GPA for accurate results.

3. **Deleting Courses:**
   - To remove a course, click the "Delete" button next to the respective course entry. The app will remove the course from the display and update the underlying data structures accordingly.
   - This feature allows users to manage their course list and make adjustments as needed.

4. **Error Handling:**
   - The app checks for empty fields and prompts users to complete all required information before proceeding with GPA calculation.
   - This feature helps prevent errors and ensures that the GPA calculation is based on complete and accurate data.

### UI Design Decisions:
The user interface of the GPA Calculator is designed to be intuitive and responsive. The main content area is managed using a `ConstraintLayout` to ensure that child views are positioned relative to each other and the parent container. The use of `LinearLayout` for course inputs and buttons helps organize elements vertically and horizontally, respectively. This design approach allows for a dynamic layout that adapts to user interactions.

### FXML Integration:
Dynamic elements in the layout are managed programmatically. In the Java code, new course entries are created and added to the `LinearLayout` with the ID `courses`. This approach ensures that each course input field is positioned correctly, maintaining a vertical list of courses based on user interactions. The use of `ConstraintLayout` and `LinearLayout` in conjunction allows for a flexible and adaptive design that adjusts to the number of courses added.

### Installation:
1. **Clone the Repository:**
   - Download or clone this repository to your local machine using Git or by downloading the ZIP file from the repository.

2. **Open the Project:**
   - Open Android Studio and select "Open an existing project."
   - Navigate to the directory where you downloaded or cloned the repository and select it.

3. **Build and Run:**
   - Once the project is loaded in Android Studio, click on the "Build" menu and select "Rebuild Project" to compile the application.
   - Connect an Android device to your computer or use an emulator to run the application.
   - Click the "Run" button in Android Studio to deploy the app to your selected device or emulator.

### Conclusion:
The GPA Calculator Android app is a practical tool for students and professionals who need to calculate their GPA efficiently. With its dynamic features, intuitive interface, and robust error handling, the app offers a reliable solution for managing and calculating academic performance. By following the installation instructions, users can quickly set up and utilize the app to streamline their GPA calculations and course management.

