var express = require('express');
var app = express();
var bodyParser = require('body-parser');
var mysql = require('mysql');

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({
    exteneded: true
}));

app.get('/',function(req,res){
    return res.send({ error: true, message: 'Test API'})
});

var dbCon = mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: '',
    database: 'tutorshare'
});

dbCon.connect();

app.get('/allstd',function(req,res){
    dbCon.query('SELECT * FROM student', function (error,results,fields){
        if (error) throw error;
        return res.send(results);
    });
});

app.get('/std/:username',function(req,res){
    var std_usr = req.params.username;
    var std_pass = req.params.password;
    console.log(std_usr)
    if(!std_usr && !std_pass){
        return res.status(400).send({ error: true,message:"Please provide student username"});
    }
    dbCon.query('SELECT * FROM student WHERE username = ? AND password = ?',[std_usr,std_pass], function (error,results,fields){
        if (error) throw error;
        if (results[0]){
        return res.send(results[0]);
        }else{
            return res.status(400).send({error: true,message:'Student username Not Found!!'});
        }
    });
    
});

app.post('/std', function(req,res){

    var std = req.body
    
    if(!std){
        return res.status(400).send({ error:true, message: 'Please provide student ' });
    }

    dbCon.query("INSERT INTO student SET ?", std , function(error, results, fields){
        if(error) throw error;
        return res.send(results);
    });
});

app.put('/std/:username',function(req,res){
    var std_user = req.params.username;
    var std = req.body
    if(!std_user || !std){
        return res.status(400).send({ error: true, message: 'Please provide student username and student data'});
    }

    dbCon.query('UPDATE student SET ? WHERE username = ?', [std, std_user], function(error,results,fields){
        if(error) throw error;
        return res.send({ error: false, message: 'Student has been updated successfully'});

    });
});

app.get('/alltutor',function(req,res){
    dbCon.query('SELECT * FROM tutor', function (error,results,fields){
        if (error) throw error;
        return res.send(results);
    });
});

app.get('/tutor/:username',function(req,res){
    var tutor_usr = req.params.username;
    if(!tutor_usr){
        return res.status(400).send({ error: true,message:"Please provide tutor username"});
    }
    dbCon.query('SELECT * FROM tutor WHERE username = ?',tutor_usr, function (error,results,fields){
        if (error) throw error;
        if (results[0]){
        return res.send(results[0]);
        }else{
            return res.status(400).send({error: true,message:'Tutor username Not Found!!'});
        }
    });
});

app.post('/tutor', function(req,res){
    var tutor = req.body
    if(!tutor){
        return res.status(400).send({ error:true, message: 'Please provide student '});
    }
    dbCon.query("INSERT INTO tutor SET ?", tutor , function(error, results, fields){
        if(error) throw error;
        return res.send(results);
    });
});

app.put('/tutor/:username',function(req,res){
    var tutor_usr = req.params.username;
    var tutor = req.body
    if(!tutor_usr || !tutor){
        return res.status(400).send({ error: true, message: 'Please provide Tutor id and Tutor data'});
    }
    dbCon.query('UPDATE tutor SET ? WHERE tutor_id = ?', [tutor, tutor_usr], function(error,results,fields){
        if(error) throw error;
        return res.send({ error: false, message: 'Tutor has been updated successfully'});
    });
});

app.get('/allcourse',function(req,res){
    dbCon.query('SELECT * FROM course', function (error,results,fields){
        if (error) throw error;
        return res.send(results);
    });
});

app.post('/course', function(req,res){
    var course = req.body
    if(!course){
        return res.status(400).send({ error: true, message: 'Please provide student '});
    }
    dbCon.query("INSERT INTO Course SET ?", course , function(error, results, fields){
        if(error) throw error;
        return res.send(results);
    });
});

app.put('/course/:id',function(req,res){
    var course_id = req.params.id;
    var course = req.body
    if(!course_id || !course){
        return res.status(400).send({ error: true, message: 'Please provide Course id and Course data'});
    }

    dbCon.query('UPDATE course SET ? WHERE course_id = ?', [course, course_id], function(error,results,fields){
        if(error) throw error;
        return res.send({ error: false, message: 'Course has been updated successfully'});
        
    });
});

app.delete('/course:id', function(req,res){
    var course_id = req.params.id;
    if(!course_id) {
        return res.status(400).send({ error:true, message: 'Please provide Course id' });
    }
    dbCon.query('DELETE FROM course WHERE course_id = ?', course_id, function(error,results, fields){
        if(error) throw error;
        return res.send({ error: false, message: 'Course has been deleted successfully'});
    });
})

app.listen(3000, function(){
    console.log('Node app is running on port 3000');
});

module.exports = app;