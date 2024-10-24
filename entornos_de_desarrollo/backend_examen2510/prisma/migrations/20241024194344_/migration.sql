/*
  Warnings:

  - The primary key for the `Departamento` table will be changed. If it partially fails, the table could be left without primary key constraint.

*/
-- AlterTable
ALTER TABLE "Departamento" DROP CONSTRAINT "Departamento_pkey",
ADD COLUMN     "id" SERIAL NOT NULL,
ADD CONSTRAINT "Departamento_pkey" PRIMARY KEY ("id");
