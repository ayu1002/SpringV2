import React from 'react';
import { Link } from 'react-router-dom';
import DatePicker from 'react-date-picker';
import Dropdown from 'react-dropdown';
import 'react-dropdown/style.css'


const RegisterFormComponent = (props) => {
    return(
            <div>
                <h1 align="center">GMSR UI Screen</h1>
                <form className="form-signin">
                <label>Start Date</label>
                <DatePicker value={ props.startDate } onChange={props.handleStartDate} id="startDate" placeholder="Start Date" required />
               <br/>
                <label>End Date</label>
                <DatePicker value= {props.endDate } onChange={props.handleEndDate} id="endDate" placeholder="End Date" required />
                <br/>
                <label>File Source</label>
                {/* <Dropdown selected= {props.selectedFileSource} value={props.selectedFileSource} options={props.fileSource}  onChange = { props.handleSelectedFileSource } placeholder="select an option"/> */}
                <select value={props.selectedFileSource} onChange={props.handleSelectedFileSource}  placeholder="select an option">
                <option value="ffirst">ffirst</option>
                <option value="fsecond">fsecond</option>
                <option value="fthird">fthird</option>
                <option value="ffourth">ffourth</option>
          </select>
                <br/>
                <label>Upload type</label>
                {/* <Dropdown selected= {props.selectedUploadType} value={props.selectedUploadType} options={props.uploadType} onChange= {props.handleSelectedUploadType} placeholder="select upload type" /> */}
                <select value={props.selectedUploadType} onChange={props.handleSelectedUploadType}  placeholder="select an option">
                <option value="uone">uone</option>
                <option value="utwo">utwo</option>
                <option value="uthird">uthird</option>
                <option value="ufourth">ufourth</option>
                </select>
                <br/>
                <label>Upload File</label>
                {/* <input type="file" value={props.fileUrl} onChange={props.handleFileUpload}  id="file" placeholder="please choose file" required /> */}
                {/* <button onClick={props.uploadHandler}>Upload</button> */}
                {/* <div>
                <input type="file" ref={(ref) => { this.uploadInput = ref; }} value={props.fileUrl} onChange={props.handleFileUpload} id="file" />
                <br /></div>
                <div>
                <input ref={(ref) => { this.fileName = ref; }} type="text" placeholder="Enter the desired name of file" />
                    </div> */}
                    <input type="file" value= { props.file } onChange={props.fileSelectedHandler} id="file" placeholder="please choose file"/>
                <label>comments</label>
                <input type = "text" value = {props.comments} onChange= {props.handleComments} id= "comments" placeholder="Please comment" />
                <Link to="/home"><button onClick={props.signIn}>Sign in</button></Link>                
            </form>
            </div>   
    );
}
export default RegisterFormComponent;
