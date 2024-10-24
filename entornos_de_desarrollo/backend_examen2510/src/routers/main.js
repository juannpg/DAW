import { PrismaClient } from '@prisma/client';
import express from 'express';

const prisma = new PrismaClient();
const router = express.Router();

router.post('/departamentos', async (req, res) => {
  const { cod_dep, nombre, loc } = req.body;
  const codInt = parseInt(cod_dep);
  const dep = await prisma.departamento.create({
    data: {
      cod_dep: codInt,
      nombre: nombre,
      localiad: loc,
    },
  });
  
  if (dep) {
    res.status(200).json({ departamento: dep });
    return;
  }

  res.status(400).json({ error: 'Error al crear el departamento' });
});

export default router;