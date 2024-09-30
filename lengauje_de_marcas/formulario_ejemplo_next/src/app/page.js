"use client";

export default function Home() {
  return (
    <main className="flex h-screen justify-center items-center">
      <form className="bg-slate-200 p-8 rounded-lg border border-gray-300 w-[600px] flex flex-col " method="POST" encType="text/plain" name="formulario">
        <div className="flex flex-col">
          <h2 className="text-xl font-bold">Datos de usuario:</h2>
          <label className="font-semibold">Usuario:</label>
          <input type="text" name="nombre" placeholder="Nombre" className="mb-1"/>
          <input type="password" name="contraseña" placeholder="Contraseña" className="mb-1"/>

          <label className="font-semibold">Fecha de nacimiento</label>
          <input placeholder="dd/mm/aaaa" type="date" name="fecha_nacimiento" className="mb-1"/>

          <label className="font-semibold">Foto DNI</label>
          <input type="file" name="DNI" className="mb-1"/>
        </div>

        <div>
          <h2 className="text-xl font-bold">Datos escolares:</h2>
          <label className="font-semibold">Cúal es tu turno? </label>
          <input placeholder="Turno" list="turno" className="mb-1"/>
          <datalist id="turno">
            <option value="Diurno" />
            <option value="Vespertino" />
          </datalist>
        
          <br/><label className="font-semibold">Cuáles son los módulos que cursas?</label><br/>
          <input type="checkbox" name="programacion" className="mb-1"/><label>Programación</label><br/>
          <input type="checkbox" name="bases" className="mb-1"/><label>Bases de datos</label><br/>
          <input type="checkbox" name="sistemas" className="mb-1"/><label>Sistemas informáticos</label><br/>
          <input type="checkbox" name="ingles" className="mb-1"/><label>Inglés</label>
        </div>

        <h3 className="text-lg font-bold">Comentarios:</h3>
        <textarea name="comentario" placeholder="Comentario" className="mb-1"></textarea>
      </form>
    </main>
  );
}
