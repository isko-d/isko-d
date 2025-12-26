import { ReactNode } from "react"
import { cookies } from "next/headers"
import { redirect } from "next/navigation"

const LoginLayout = async ({ children }: { children: ReactNode }) => {
  const userCookies = await cookies();
  const token = userCookies.get("api_token");

  if (token) redirect("/admin7vsuo5zd");

  return (
    <>{children}</>
  )
}

export default LoginLayout;
