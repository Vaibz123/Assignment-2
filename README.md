# Assignment-2


View Students:Displays list of all students along with tests
url: http://localhost:8080/student/all

Create student:
url: http://localhost:8080/student
JSON data to be passed in body
{
    "name": "William",
    "age": 80
}

Add test:
url: http://localhost:8080/test/10001

JSON data to be passed in body
{
        "name": "Economics",
        "marks": 85
}


Update student:
url: http://localhost:8080/student/10002

Here id=10002
JSON data to be passed in body
{
    "name": "Tina",
    "age": 46,
    
}

Delete student:
//deletes students alongwith related tests

url: http://localhost:8080/student/10004


GetAllTop Student:
//Displays list of toppers with percentage>80%

url: http://localhost:8080/student
