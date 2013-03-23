K:\Program Files\Apache Software Foundation\Tomcat 6.0\webapps\CAB\WEB-INF\classes>javac -classpath "K:\Program Files\Apache
Software Foundation\Tomcat 6.0\lib\servlet-api.jar" AddUserServlet.java




// Prepare messages.
        Map<String, String> messages = new HashMap<String, String>();
        request.setAttribute("messages", messages);

        // Get and validate name.
        String name = request.getParameter("name");
        if (name == null || name.trim().isEmpty()) {
            messages.put("name", "Please enter name");
        } else if (!name.matches("\\p{Alnum}+")) {
            messages.put("name", "Please enter alphanumeric characters only");
        }

        // Get and validate age.
        String age = request.getParameter("age");
        if (age == null || age.trim().isEmpty()) {
            messages.put("age", "Please enter age");
        } else if (!age.matches("\\d+")) {
            messages.put("age", "Please enter digits only");
        }

        // No validation errors? Do the business job!
        if (messages.isEmpty()) {
            messages.put("success", String.format("Hello, your name is %s and your age is %s!", name, age));
        }

        request.getRequestDispatcher("/WEB-INF/hello.jsp").forward(request, response);


        <label>User Id</label>adasdsadsadasd
<input type='text' name='username' class='username'>
<button name='btnAdd' id='edit_find'>Find</button>
<!-- <div class='record'>
    <form name='reset-password'>
        <label>User Id </label>
            <input type='text' class='username' name='username' disabled><br>
        <label>First Name </label>
            <input type='text' class='fname' name='fname' disabled><br>
        <label>Last Name </label>
            <input type='text' class='lname' name='lname' disabled><br>
        <label>New Password </label>
            <input type='text' class='password' name='password'><br>
        <input type='submit' class='btnSubmit' name='btnSubmit'> <input type='reset' class='btnCancel' name='btnCancel'>
    </form>
</div> -->