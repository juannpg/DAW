import "./globals.css";

export const metadata = {
  title: "Formulario Ejemplo Next",
};

export default function RootLayout({ children }) {
  return (
    <html lang="en">
      <body>
        {children}
      </body>
    </html>
  );
}
