import { cookies } from "next/headers"
import { redirect } from "next/navigation"

const AdminLayout = async ({ children }) => {
  const userCookies = await cookies();
  const token = userCookies.get("api_token");

  if (!token) redirect("/admin7vsuo5zd/login");

  return (
    <>{children}</>
  )
}

export default AdminLayout;
