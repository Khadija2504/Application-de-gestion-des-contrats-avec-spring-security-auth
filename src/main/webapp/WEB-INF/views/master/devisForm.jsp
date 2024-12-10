<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Request Devis</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        form {
            background: white;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            margin: auto;
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        input, select {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        button {
            background-color: #5cb85c;
            color: white;
            padding: 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            width: 100%;
        }
        button:hover {
            background-color: #4cae4c;
        }
    </style>
</head>
<body>
<h2>Request a Devis</h2>
<form action="${pageContext.request.contextPath}/devis/calculate" method="post">
    <label for="type">Type:</label>
    <select id="type" name="type" required>
        <option value="Sante">Sante</option>
        <option value="Automobile">Automobile</option>
        <option value="Hbitation">Habitation</option>
    </select>
    <input type="hidden" value="1" name="userId">

    <label for="age">Age:</label>
    <input type="number" id="age" name="age" required>

    <label for="valeurBien">Valeur Bien:</label>
    <input type="number" id="valeurBien" name="valeurBien">

    <label for="typeVehicule">Type Véhicule:</label>
    <input type="text" id="typeVehicule" name="typeVehicule">

    <label for="isProfessionalUse">Professional Use:</label>
    <select id="isProfessionalUse" name="isProfessionalUse">
        <option value="true">Yes</option>
        <option value="false">No</option>
    </select>

    <label for="noClaims">No Claims:</label>
    <select id="noClaims" name="noClaims">
        <option value="true">Yes</option>
        <option value="false">No</option>
    </select>

    <label for="typeLogement">Type Logement:</label>
    <input type="text" id="typeLogement" name="typeLogement">

    <label for="isRiskZone">Risk Zone:</label>
    <select id="isRiskZone" name="isRiskZone">
        <option value="true">Yes</option>
        <option value="false">No</option>
    </select>

    <label for="hasSecuritySystem">Security System:</label>
    <select id="hasSecuritySystem" name="hasSecuritySystem">
        <option value="true">Yes</option>
        <option value="false">No</option>
    </select>

    <label for="hasChronicIllness">Chronic Illness:</label>
    <select id="hasChronicIllness" name="hasChronicIllness">
        <option value="true">Yes</option>
        <option value="false">No</option>
    </select>

    <label for="coverageType">Coverage Type:</label>
    <input type="text" id="coverageType" name="coverageType">

    <input type="hidden" name="userId" value="${userId}"> <!-- Assuming userId is available in the context -->

    <button type="submit">Submit</button>
</form>
</body>
</html>