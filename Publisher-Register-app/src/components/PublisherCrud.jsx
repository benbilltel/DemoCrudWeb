import { Fragment, useState } from "react";
import apiPublisher from "../api/AxiosConfig";
import PublisherList from "./PublisherList";
function PublisherCrud ({load,publishers}) {
    const [id,setId] = useState("");
    const [name,setName] = useState("");
    const [email,setEmail] = useState("");
    const [published,setPublished] = useState("");

    async function save(event){
        event.preventDefault();
        await apiPublisher.post("/create",{
            name: name,
            email:email,
            published:published,
        })
        alert("Saved!")
        setId("");
        setName("");
        setEmail("");
        setPublished("");
        load();
    }
    async function editEmployee(publishers){
        setName(publishers.name);
        setEmail(publishers.email);
        setPublished(publishers.published);
        setId(publishers.id);
    }
    async function deleteEmployee(id){
        await apiPublisher.delete("/delete/"+id);
        alert("deleted!")
        load();
    }
    async function update(event){
        event.preventDefault();
        if(!id){
            return alert("Not found!");
        }
        await apiPublisher.put("/update",{
            id:id,
            name:name,
            email:email,
            published:published,
        })
        alert("Updated")
        setId("");
        setName("");
        setEmail("");
        setPublished("");
        load();
    }
    

    return (<div className="container mt-4">
        <form>
            <div className="form-group my-2">
                <input type="text" className="form-control" value={id} onChange={e=>{
                    setId(e.target.value)
                }} />
                <label>Name</label>
            <input type="text" className="form-control" value={name} onChange={e=>{
                setName(e.target.value)
            }} />
            </div>
            <div className="form-group mb-2">
                
                <label>Email</label>
            <input type="text" className="form-control" value={email} onChange={e=>{
                setEmail(e.target.value)
            }} />
            </div>
            <div className="row">
          <div className="col-4">
            <label>Published</label>
            <input
              type="text"
              className="form-control"
              value={published}
              placeholder="Published"
              onChange={e => setPublished(e.target.value)}
            />
          </div>
        </div>
        <div>
          <button className="btn btn-primary m-4" onClick={save}>
            Register
          </button>
          <button className="btn btn-warning m-4" onClick={update}>
            Update
          </button>
        </div>
        </form>
        <PublisherList
        publishers={publishers}
        editEmployee={editEmployee}
        deleteEmployee={deleteEmployee}
      />
    </div>);
}
export default PublisherCrud;