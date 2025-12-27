const apiFetch = async (
  resource: string,
  options: Record<string, any>
) => {
  const res = await fetch(`${process.env.API_URL}${resource}`, {
    method: options.method ?? "GET",
    headers: {
      "Content-Type": "application/json",
      ...options?.headers,
    },
    credentials: "include",
    ...options
  });

  if (!res.ok) throw new Error(await res.text());

  return res.json();
}

export default apiFetch;
