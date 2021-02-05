# Assignment-2


View Students:Displays list of all students along with tests</br></br>
url: http://localhost:8080/student/all
</br></br>
Create student:</br>
url: http://localhost:8080/student</br>
JSON data to be passed in body </br></br>
{
    "name": "William",
    "age": 80
}
</br></br>
Add test:</br>
url: http://localhost:8080/test/10001</br>
</br>
JSON data to be passed in body</br>
{
        "name": "Economics",
        "marks": 85
}

</br></br>
Update student:</br>
url: http://localhost:8080/student/10002</br>
</br>
Here id=10002</br>
JSON data to be passed in body</br>
{
    "name": "Tina",
    "age": 46,
    
}</br>
</br>
Delete student:</br>
//deletes students alongwith related tests</br>
</br>
url: http://localhost:8080/student/10004
</br>
</br>
GetAllTop Student:</br>
//Displays list of toppers with percentage>80%</br>

url: http://localhost:8080/student</br>
