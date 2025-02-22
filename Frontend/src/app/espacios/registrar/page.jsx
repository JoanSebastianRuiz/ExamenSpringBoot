"use client"

import {useForm} from "react-hook-form"
import axios from "axios";
import { useState, useEffect } from "react";
import Link from "next/link";

const UsuariosRegistrarPage = () =>{
    const {handleSubmit, register} = useForm();
    const [tiposEspacio, setTiposEspacio] = useState([]);

    const obtenerTipoEspacio = async()=>{
        const respuesta = await axios.get("http://localhost:8081/tipos-espacio");
        setTiposEspacio(respuesta.data)
    }

    useEffect(()=>{
        obtenerTipoEspacio();
    },[])

    const onSubmit = async(data) =>{
        const respuesta = await axios.post("http://localhost:8081/espacios", data);
        alert(respuesta.data);
    }

    return(
        <div>
            <Link href="/espacios">Espacios</Link>
            <form className="flex flex-col gap-5 mx-auto w-96 " onSubmit={handleSubmit(onSubmit)}>
            <h1>Registrar espacio</h1>
            <label htmlFor="idTipoEspacio">Tipo de espacio</label>
            <select id="idTipoEspacio" {...register("idTipoEspacio")}>
                {tiposEspacio.map((espacio)=>{
                    return(
                        <option key={espacio.id} value={espacio.id}>{espacio.nombre}</option>
                    )
                })}
            </select>

            <label htmlFor="nombre">Nombre</label>
            <input type="text" id="nombre" className="border border-black" required {...register("nombre")}/>

            <label htmlFor="capacidad">Capacidad</label>
            <input type="number" min={1} id="capacidad" className="border border-black" required {...register("capacidad")} />

            <label htmlFor="disponibilidad">Disponibilidad</label>
            <select id="disponibilidad" required {...register("disponibilidad")}>
                <option value={true} selected>Disponible</option>
                <option value={false}>No disponible</option>
            </select>

            <button>Registrar</button>
            
        </form>
        </div>
        
    )
}

export default UsuariosRegistrarPage;