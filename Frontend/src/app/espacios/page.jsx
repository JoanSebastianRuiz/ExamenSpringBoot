"use client"

import Link from "next/link";
import axios from "axios";
import { useState, useEffect } from "react";

const EspaciosPage = () => {
    const obtenerEspacios = async()=>{
        const respuesta = await axios.get("http://localhost:8081/espacios");
        setEspacios(respuesta.data)
    }

    const [espacios, setEspacios] = useState([]);

    const eliminarEspacio = async(id) =>{
        const respuesta = await axios.delete(`http://localhost:8081/espacios/${id}`);
        alert(respuesta.data);
        obtenerEspacios();
    }

    useEffect(()=>{
        obtenerEspacios();
    }
    ,[])

    return (
        <div>
            Espacios

            <ul>
                <li><Link href="/espacios/registrar">Registrar</Link></li>
                <li><Link href="/espacios/actualizar">Actualizar</Link></li>
            </ul>

            <div>
                {espacios.map((espacio)=>{
                    return(
                        <div key={espacio.id} className="border border-black">
                            <h1>{espacio.nombre}</h1>
                            <p>{espacio.capacidad}</p>
                            <p>{espacio.disponibilidad ? "Disponible" : "No disponible"}</p>
                            <button onClick={()=>eliminarEspacio(espacio.id)} className="text-red-500">Eliminar</button>
                            <button>Actualizar</button>
                        </div>
                    )
                })}
            </div>
        </div>
    );
    }

    export default EspaciosPage;