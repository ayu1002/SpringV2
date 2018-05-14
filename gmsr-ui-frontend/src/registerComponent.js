import React from 'react';
import axios from 'axios';
import RegisterFormComponent from './registerFormComponent';
import DatePicker from 'react-date-picker';

export class RegisterComponent extends React.Component {
    constructor(props) {
        super(props);
        this.handleStartDate = this.handleStartDate.bind(this);
        this.handleEndDate = this.handleEndDate.bind(this);
        this.handleSelectedFileSource = this.handleSelectedFileSource.bind(this);
        this.handleSelectedUploadType = this.handleSelectedUploadType.bind(this);
        //this.handleFileUpload = this.handleFileUpload.bind(this);
        this.fileSelectedHandler = this.fileSelectedHandler.bind(this);
        this.handleComments = this.handleComments.bind(this);
        
        this.signIn=this.signIn.bind(this);

        this.state = {
          startDate : '',
          endDate : '',
        //fileSource : [ 'one', 'two', 'three'],
        selectedFileSource : 'ffirst',
         //uploadType : ['uone', 'utwo', 'uthree'],
         selectedUploadType : 'uone',
         file : null,
         comments : ''
        };
    }

    handleStartDate(date){
        this.setState({ startDate : date })
        console.log(this.state.startDate);
        console.log(this.state.file);
    }

    handleEndDate(date){
        this.setState({ endDate : date })
        console.log(this.state.endDate);
    }

    handleSelectedFileSource(event){
        // console.log(data);
        // this.setState({ selectedFileSource : data })
        // console.log(event.target.value);
        this.setState({ selectedFileSource : event.target.value })
        console.log(this.state.selectedFileSource);
     }

    handleSelectedUploadType(event){
        this.setState({ selectedUploadType : event.target.value })
        console.log(this.state.selectedUploadType);
        // console.log(event.target.value);
        
    }


    fileSelectedHandler(event) {
        console.log(event.target.files[0]);
        this.setState({ file : event.target.files[0] });
        console.log(this.state.file);
        const formData = new FormData();
         formData.append('file', event.target.files[0]);
       //  formData.append('filename', this.fileName.value);
    }


    // handleFileUpload(event) {
    //         event.preventDefault();
    //         const formData = new FormData();
           
    //         formData.append('file', this.uploadInput.files[0]);
    //         formData.append('filename', this.fileName.value);
    //         this.setState({ fileUrl : event.target.value });
    //       //  console.log(this.state.file);
    //     //    const fileUrl= event.target.files[0]
    //     //   this.setState({ fileUrl : event.target.files[0] })
    //        console.log(this.state.file);
    // }

    // uploadHandler(event) {
    //     event.preventDefault
    //     console.log(this.state.file)
    // }



    handleComments(event){
        this.setState({comments :event.target.value})
        console.log(this.state.comments);
    }

    signIn(event){
        event.preventDefault();
        console.log(this.state);
        axios.post('http://localhost:8080/file/upload', {
            startDate: this.state.startDate,
            endDate: this.state.endDate,
            selectedFileSource : this.state.selectedFileSource,
            selectedUploadType: this.state.selectedUploadType,
             file : this.state.file,
            data : this.formData,
            comments : this.state.comments,
            data: this.formData,
            config: { headers: {'Content-Type': 'multipart/form-data' }}
          })
          .then(function (response) {
            console.log(response);
          })
          .catch(function (error) {
            console.log(error);
          });  
    //     var userCredentials = new Object();
    //     userCredentials.startDate = this.state.startDate;
    //     userCredentials.endDate = this.state.endDate;
    //     userCredentials.selectedFileSource = this.state.selectedFileSource;
    //     userCredentials.selectedUploadType = this.state.selectedUploadType;
    //     userCredentials.file = this.state.file;
    //     userCredentials.comments = this.state.comments;
    //       console.log(JSON.stringify(userCredentials));  

    //       fetch('http://localhost:8080/file/upload', {
    //         method: 'post',
    //         body: JSON.stringify(userCredentials),
    //         headers: {'Content-Type':'application/json',
    //                     'Accept': 'application/json'
    //        } 
    //     })
    //        .then(function (response) {
    //             console.log(response);
    //           })

    //           .then(data => console.log(data))
              
    //           .catch(function (error) {
    //             console.log(error);
    //           }); 
          
     }

    render() {
        return(
            < RegisterFormComponent 
                handleStartDate = { this.handleStartDate }
                handleEndDate = { this.handleEndDate }
                handleSelectedFileSource = { this.handleSelectedFileSource }
                handleSelectedUploadType = { this.handleSelectedUploadType }
               // handleFileUpload = { this.handleFileUpload } 
               fileSelectedHandler = { this.fileSelectedHandler } 
                handleComments = { this.handleComments }

                startDate = { this.state.startDate }
                endDate = { this.state.endDate }
              //  fileSource = { this.state.fileSource}
                // uploadType = { this.state.uploadType }
                signIn = { this.signIn }
            />
        );
    }
}